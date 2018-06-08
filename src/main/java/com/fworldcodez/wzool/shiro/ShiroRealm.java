package com.fworldcodez.wzool.shiro;

import com.fworldcodez.wzool.config.ShiroConfig;
import com.fworldcodez.wzool.dto.UserDto;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
    @Autowired
    UserService userService;
    /**
     * 授权查询回调函数，进行鉴权但缓存中无用户的授权信息时调用，负责在应用程序中决定用户的访问控制方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //利用登陆用户的信息作为当前用户的角色或权限
        Set<String> roles = new HashSet<>();
        //创建SimpleAuthorizationInfo对象，并且添加用户权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证回调函数，登录信息和用户验证信息验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //把AuthenticationToken 转换为UserNamePassWordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //UsernamePasswordToken 获取用户名和密码
        String userName = usernamePasswordToken.getUsername();
        String passWord= String.valueOf(usernamePasswordToken.getPassword());
        UserDto userDto=new UserDto();
        User user=new User();
        userDto.setUserName(userName);
        userDto.setUserPassWord(passWord);
        user = userService.login(userDto);
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if(!user.getUserName().equals(userName)){
            throw new UnknownAccountException("用户不存在!");
        }
        //当前 Realm 的 name
        String realmName = this.getName();
        // 若存在，将此用户存放到登录认证simpleAuthenticationInfo中，无需自己做密码对比，Shiro会为我们进行密码对比校验
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName,passWord,realmName);
        return simpleAuthenticationInfo;
    }
}
