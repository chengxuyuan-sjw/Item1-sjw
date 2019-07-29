package com.sheng.Action;


import com.sheng.Service.IEmpServiceBack;
import com.sheng.Service.back.IItemServiceBack;
import com.sheng.Service.back.ITravelServiceBack;
import com.sheng.Service.back.ITravel_EmpServiceBack;
import com.sheng.vo.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/*")
public class TravelEmpAction {
    @Resource(name = "IItemServiceBackImpl")
    private IItemServiceBack iItemService;
    @Resource(name = "ITravelServiceBackImpl")
    private ITravelServiceBack travelService;
    @Resource(name = "ITravel_EmpServiceBackImpl")
    private ITravel_EmpServiceBack travel_empServiceBack;
    @Resource(name = "IEmpServiceBackImpl")
    private IEmpServiceBack EmpService;
    @InitBinder
    public void iniiBinder(WebDataBinder binder) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }

    //显示雇员列表详情
    @RequestMapping("TravelEmpList")
    public ModelAndView TravelEmpList(String column, String keyword, Integer start){
        ModelAndView md=new ModelAndView();
        Map<String,Object> map=travel_empServiceBack.findAllsplit(column,keyword,start,5);
        List<Travel_Emp> list=(List<Travel_Emp>) map.get("travelEmps");
        int count=(Integer) map.get("count");
        Map<String,Object> map1=EmpService.AllEmp();
        List<Emp> emps=(List<Emp>) map1.get("emps");
        List<Dept> depts=(List<Dept>)map1.get("depts");
        List<Level> levels=(List<Level>)map1.get("levels");
        List<Travel> travels=travelService.findAll();
        md.addObject("emps",emps);
        md.addObject("depts",depts);
        md.addObject("levels",levels);
        md.addObject("count",(count+5)/5);
        md.addObject("list",list);
        md.addObject("travels",travels);
        md.setViewName("/travelEmp-list.jsp");
        return md;
    }
}
