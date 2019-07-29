package com.sheng.Action;

import com.sheng.Service.back.IDeptServiceBack;
import com.sheng.vo.Dept;
import com.sheng.vo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/*")
public class DeptAction {
    @Resource(name = "IDeptServiceBackImpl")
    public IDeptServiceBack deptServiceBack;
    //显示部门列表信息
    @RequestMapping("DeptList")
    public ModelAndView list(){
        ModelAndView md=new ModelAndView();
        Map<String,Object> map=deptServiceBack.list();
        List<Dept> allDept=(List<Dept>) map.get("AllDept");
        List<Emp> allEmp=(List<Emp>)map.get("AllEmp");
        //建立一个map,存放eid和ename,便于获取部门领导的姓名
        Map<String,Object> Emps=new HashMap<String, Object>();
        Iterator<Emp> iter=allEmp.iterator();
        while (iter.hasNext()){
            Emp emp=new Emp();
            emp=iter.next();
            Emps.put(emp.getEid(),emp.getEname());
        }
        md.addObject("AllDept",allDept);
        md.addObject("EmpMap",Emps);
        md.setViewName("/table-font-list.jsp");
        return md;
    }


    //Ajax异步修改部门名称
    @ResponseBody
    @RequestMapping(value = "UpdateDname",method= RequestMethod.POST)
    public boolean updateDname(@RequestBody Dept dept) {
        return deptServiceBack.UpdateDname(dept);

    }
}
