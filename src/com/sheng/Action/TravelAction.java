package com.sheng.Action;


import com.sheng.Service.back.IItemServiceBack;
import com.sheng.Service.back.ITravelServiceBack;
import com.sheng.Service.back.ITravel_EmpServiceBack;
import com.sheng.vo.Emp;
import com.sheng.vo.Item;
import com.sheng.vo.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller()
@RequestMapping("/*")
public class TravelAction {
    @Resource(name = "IItemServiceBackImpl")
    private IItemServiceBack iItemService;
    @Resource(name = "ITravelServiceBackImpl")
    private ITravelServiceBack travelService;
    @Resource(name = "ITravel_EmpServiceBackImpl")
    private ITravel_EmpServiceBack travel_empServiceBack;
    @InitBinder
    public void iniiBinder(WebDataBinder binder) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }
    //创建差旅申请的控制层
    @RequestMapping("CreatTravel")
    public ModelAndView creatTravel(Travel travel){
        ModelAndView md=new ModelAndView();
            travel.setAudit(0);
            travel.setTotal(0.0);
            travel.setSubdate(new Date());
       if (travelService.creatTravel(travel)){
          md.setViewName("/Travel-add-success.jsp");
       }else {
           md.setViewName("/Travel-add-errror.jsp");
       }
      return md;
    }

   @RequestMapping("CreatDeatilList")
    public ModelAndView CreatDeatils(){
        ModelAndView md=new ModelAndView();
        //获得出行类型的详细分类
        List<Item> list=iItemService.getDeatils();
        md.addObject("items",list);
        md.setViewName("/travel-creat.jsp");
        return md;
   }

    @Autowired
    HttpServletRequest request;
   //用于显示用户个人申请显示界面,因此时暂时没有用户名称,seid设置为null
   @RequestMapping("TravelsList")
    public ModelAndView TravelList(String column,String keyword,Integer start){
       String seid;
       String str;
       //获得当前登陆用户的角色信息,判断如果角色是财政部经理或者员工,那么可以显示全部信息
       Set roles=(Set)request.getSession().getAttribute("role");
       if (roles.contains("financemanager")||roles.contains("financeemp")){
           seid=null;
       }else {
           seid=(String) request.getSession().getAttribute("eid");
       }
        //获得详细信息,seid暂时没有shiro所有暂设置为null,linesize直接传入为5
       Map<String,Object>map= travelService.findAllTravel(seid,column,keyword,start,5);
       ModelAndView md=new ModelAndView();
       md.addObject("travels",map.get("travels"));
       md.addObject("count",(((Integer)map.get("count"))+4)/5);
       md.setViewName("/travel-list.jsp");
       return md;
   }


    @RequestMapping("deleteTravel")
    @ResponseBody
    public boolean deleteTravel(@RequestBody Travel travel){
      return travelService.DeleteTravel(travel);
    }


    //负责从数据显示原始信息,当用户跳转入修改界面的时候,给用户提醒进行显示
    @RequestMapping("EditListplaceholder")
    public ModelAndView eidtplace(Travel travel){
        ModelAndView md=new ModelAndView();
        List<Item> list=iItemService.getDeatils();
        md.addObject("items",list);
        md.addObject("deatils",travelService.findDeatilsById(travel));
        md.setViewName("/travel-edit.jsp");
        return md;
    }


    //负责更新更新出差信息的页面,正确跳转正确页面,错误跳转错误页面
    @RequestMapping("UpdateTravel")
    public ModelAndView updateTravel(Travel travel){
        ModelAndView md=new ModelAndView();
        travel.setSubdate(new java.util.Date());
        System.out.println(travel.toString());
        if (travelService.UpdateTravel(travel)){
            md.setViewName("/Travel-forword-success.jsp");
        }else {
            md.setViewName("/Travel-forword-error.jsp");
        }
        return md;
    }


    //负责Ajax点击查看雇员详情的按钮
    @RequestMapping("TravelModel")
    @ResponseBody
    public List<Emp> insertModel(@RequestBody Travel travel){
         ModelAndView md=new ModelAndView();
         List<Emp> emps=travel_empServiceBack.findTravelEmp(travel.getTid());
         return emps;
    }


    //负责ajax审批申请情况
    @RequestMapping("Approval")
    @ResponseBody
    public boolean UpdateAudit(@RequestBody Travel travel){
        travel.setAuddate(new Timestamp(new Date().getTime()));
        System.out.println(travel.toString());
        return travelService.UpdateAutid(travel);
    }

    //负责ajax提交申请,变更状态
    @RequestMapping("submit")
    @ResponseBody
    public boolean Submit(@RequestBody Travel travel){
        return  travelService.UpdateSubmit(travel);
    }


    //负责根据audit进行多个页面查看travel数据
    @RequestMapping("TravelListByAudit")
    public ModelAndView TravelListByAudit(String column, String keyword, Integer start, Integer linesize,String audit){
        ModelAndView md=new ModelAndView();
        Map<String,Object> map= travelService.findSplitByAudit(column,keyword,start,5,audit);
        md.addObject("count",map.get("count"));
        md.addObject("travels",map.get("travels"));
        md.setViewName("/unaudited-list.jsp");
        return md;
    }
}
