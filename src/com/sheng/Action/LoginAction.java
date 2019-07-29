package com.sheng.Action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/*")
public class LoginAction {
    @RequestMapping(value = "LoginUrl" ,method = RequestMethod.POST)
    public ModelAndView LoginUrl(String eid, String password){
        ModelAndView md=new ModelAndView();
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(eid,password);
        try {
            subject.login(token);
            md.setViewName("/DeptList.action");
        }catch (Exception e){
            e.printStackTrace();
            md.setViewName("/login.jsp");
        }

        return md;

    }

    @RequestMapping("LoginOut")
    public ModelAndView Loginout(){
        ModelAndView md=new ModelAndView();
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.logout();
        }catch (Exception e){
            e.printStackTrace();
        }
        md.setViewName("/login.jsp");
        return md;
    }
}
