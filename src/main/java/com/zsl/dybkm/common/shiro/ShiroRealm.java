package com.zsl.dybkm.common.shiro;

import com.zsl.dybkm.sys.entity.SysUser;
import com.zsl.dybkm.sys.service.ISysRolePermService;
import com.zsl.dybkm.sys.service.ISysRoleService;
import com.zsl.dybkm.sys.service.ISysUserService;
import com.zsl.dybkm.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * 同时开启身份验证和权限验证，需要继承 AuthorizingRealm
 * 并实现其  doGetAuthenticationInfo()和 doGetAuthorizationInfo 两个方法
 */
@SuppressWarnings("serial")
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysRolePermService sysRolePermService;

    /**
     * 限定这个 Realm 只处理 UsernamePasswordToken
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 查询数据库，将获取到的用户安全数据封装返回
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 从 AuthenticationToken 中获取当前用户
        String username = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        // 查询数据库获取用户信息，此处使用 Map 来模拟数据库
        SysUser user = sysUserService.getByUserName(username);

        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 账号锁定
        if (user.getStatus() == 1) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

    /**
     * 查询数据库，将获取到的用户的角色及权限信息返回
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取当前用户
        SysUser currentUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        // UserEntity currentUser = (UserEntity)principals.getPrimaryPrincipal();
        // 查询数据库，获取用户的角色信息
        //Set<String> roles = sysRoleService.getById()
        // 查询数据库，获取用户的权限信息
        //Set<String> perms = permMap.get(currentUser.getName());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.setRoles(roles);
        //info.setStringPermissions(perms);
        return info;
    }

}