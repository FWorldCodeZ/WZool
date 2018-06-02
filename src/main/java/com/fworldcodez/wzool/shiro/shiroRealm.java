package com.fworldcodez.wzool.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.HashSet;
import java.util.Set;

public class shiroRealm extends AuthorizingRealm {
    /**
     * 授权查询回调函数，进行鉴权但缓存中无用户的授权信息时调用，负责在应用程序中决定用户的访问控制方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
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
        //当前 Realm 的 name
        String realmName = this.getName();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName,passWord,realmName);
        return simpleAuthenticationInfo;
    }
}
