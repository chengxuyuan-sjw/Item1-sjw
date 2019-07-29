package com.sheng.Realm;

import com.sheng.Service.IEmpServiceBack;
import com.sheng.vo.Emp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * shiro框架中Realm,目的是为了用户登陆的验证
 */
@Component
public class EmpRealm extends AuthorizingRealm {
    @Resource(name = "IEmpServiceBackImpl")
    private IEmpServiceBack Service;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.从权限参数中取出用户名
        String eid= (String) principalCollection.getPrimaryPrincipal();
        //2.角色权限认证一般交由AuthorizationInfo的子类SimpleAuthorization进行处理
        SimpleAuthorizationInfo auth=new SimpleAuthorizationInfo();
        //3.取出根据登陆用户名查询出的角色权限信息
        Emp emp=new Emp();
        emp.setEid(eid);
        Map<String,Object> map=Service.findRoleAndActionByEmp(emp);
        Set<String> roles=(Set<String>) map.get("roles");
        Set<String> actions=(Set<String>) map.get("actions");
        SecurityUtils.getSubject().getSession().setAttribute("role",roles);
        //4.传入负责角色认证的类
        auth.setRoles(roles);
        auth.setStringPermissions(actions);
        //5.返回处理类对象
        return auth;
    }

    /**
     * 登陆验证
     * @param Token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        String eid=(String) Token.getPrincipal();
        String password=new String((char[])Token.getCredentials());
        Emp emp=Service.EmpLogin(eid);
        if ("".equals(emp)||emp==null){
            throw new UnknownAccountException("用户不存在");
        }else {
            if (emp.getPassword().equals(password)){
                if (!emp.getLocked().equals(1)) {
                    //向Session中传递数据
                    SecurityUtils.getSubject().getSession().setAttribute("ename",emp.getEname());
                    SecurityUtils.getSubject().getSession().setAttribute("photo",emp.getPhoto());
                    SecurityUtils.getSubject().getSession().setAttribute("eid",emp.getEid());
                    //返回simpleAuthenticationInfo对象交由security自动处理
                    return new SimpleAuthenticationInfo(eid, password, "EmpRealm");
                }else {
                    throw new LockedAccountException("账号被锁定,无法使用");
                }
            }else {
                throw  new IncorrectCredentialsException("密码错误");
            }
        }


    }
}
