package com.fworldcodez.wzool.shiro;

import com.fworldcodez.wzool.common.Md5Util;
import com.fworldcodez.wzool.config.MyConfig;
import com.fworldcodez.wzool.dto.UserDto;
import com.fworldcodez.wzool.pojo.Role;
import com.fworldcodez.wzool.pojo.User;
import com.fworldcodez.wzool.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    @Autowired
    UserService userService;
    @Autowired
    private MyConfig myConfig;

    /**
     * 权限认证（为当前登录的Subject授予角色和权限）
     * <p>
     * 该方法的调用时机为需授权资源被访问时，并且每次访问需授权资源都会执行该方法中的逻辑，这表明本例中并未启用AuthorizationCache，
     * 如果连续访问同一个URL（比如刷新），该方法不会被重复调用
     * doGetAuthorizationInfo()是权限控制，
     * 当访问到页面的时候，使用了相应的注解或者shiro标签才会执行此方法否则不会执行，
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可
     * <p>
     * 授权查询回调函数，进行鉴权但缓存中无用户的授权信息时调用，负责在应用程序中决定用户的访问控制方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        User user = (User) principalCollection.getPrimaryPrincipal();
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user1= (User) session.getAttribute(myConfig.sessionInfo);
        logger.info("shiro=----user.getId()"+user.getId());
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleList());
            //用户的权限集合
            info.addStringPermissions(user.getPerminsStrlist());

            return info;
        }
        ////利用登陆用户的信息作为当前用户的角色或权限
//        Set<String> roles = new HashSet<>();
//        //创建SimpleAuthorizationInfo对象，并且添加用户权限
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;

//

    }

    /**
     * 登录认证
     * 认证回调函数，登录信息和用户验证信息验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //把AuthenticationToken 转换为UserNamePassWordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //UsernamePasswordToken 获取用户名和密码
        String userName = usernamePasswordToken.getUsername();
        String passWord = String.valueOf(usernamePasswordToken.getPassword());
        UserDto userDto = new UserDto();
        User user = new User();
        userDto.setUserName(userName);
        userDto.setUserPassword(passWord);
        user = userService.login(userDto);
        String md5Pwd=Md5Util.smallmd5(passWord+user.getSalt());
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if (!user.getUserName().equals(userName)) {
            throw new UnknownAccountException("用户不存在!");
        }
        //当前 Realm 的 name
        String realmName = this.getName();
        // 若存在，将此用户存放到登录认证simpleAuthenticationInfo中，无需自己做密码对比，Shiro会为我们进行密码对比校验
        //参数解释1.用户名2.登陆密码3.盐值4，realmName
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),passWord,ByteSource.Util.bytes(user.getSalt()),realmName);
        return simpleAuthenticationInfo;
    }
}
