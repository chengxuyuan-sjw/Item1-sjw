package com.sheng.Action;

import com.sheng.Service.IEmpServiceBack;
import com.sheng.vo.Dept;
import com.sheng.vo.Emp;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/*")
public class EmpAction {
    //注入信息储存类,所有的properties信息验证文件都会在application中配置注入到其中
    @Resource(name = "MessageSource")
    private MessageSource messageSource;
    @Resource(name = "IEmpServiceBackImpl")
    private IEmpServiceBack EmpService;
    //定义方法根据key取出properities规定的信息
    public String getMessage(String key){
        return this.messageSource.getMessage(key,null,Locale.getDefault());
    }
    @RequestMapping("ModelEmpList")
    @ResponseBody
    public Map list(@RequestBody Emp emp){
        String eid=emp.getEid();
        System.out.println(eid);
        Map<String,Object>map=EmpService.getDeatiByeid(eid);
        return map;
    }

    @RequestMapping("UpdateManager")
    @ResponseBody
    public boolean UpdateManager(@RequestBody Dept dept){
        Long did=dept.getDid();
        String eid=dept.getEid();
       return  EmpService.UpdateDeptManager(did,eid);

    }

    //用户显示dept,emp,level表的全部信息,雇员页面填充选择项
    @RequestMapping("ListAll")
    public ModelAndView ListAll(){
        ModelAndView md=new ModelAndView("/emp-add.jsp");
        Map<String,Object>map= EmpService.AllEmp();
        md.addObject("emps",map.get("emps"));
        md.addObject("levels",map.get("levels"));
        md.addObject("depts",map.get("depts"));
        return md;
    }


    //用户ajax异步验证,此用户名是否存在重名用户
    @RequestMapping("AjaxReset")
    @ResponseBody
    public boolean AjaxReset(@RequestBody Emp emp){
        return EmpService.EmpLogin(emp.getEid())==null;
    }


    @RequestMapping("LimitEmp")
    public ModelAndView LimitEmp(String column,String keyword,Integer start){
        int linesize=5;
        Map<String,Object> map=EmpService.EmpList(column,keyword,linesize,start);
        int count=(int)map.get("count");
        ModelAndView md=new ModelAndView();
        md.setViewName("/emp-list.jsp");
        md.addObject("count",(count+5)/5);
        md.addObject("emps",map.get("emps"));
        return md;
    }

    @RequestMapping("EmpUpdate")
    public ModelAndView UpdateEmp(String eid, Long did, String lid, String phone, Integer locked){
        ModelAndView md=new ModelAndView();
        if (EmpService.EmpEdit(eid,did,lid,phone,locked)){
            md.setViewName("/LimitEmp.action");
        }else {
            md.setViewName("/emp-edit.jsp");
        }
        return md;
    }

    @RequestMapping("UpdateLocked")
    @ResponseBody
    public boolean UpdateLocked(@RequestBody String ids){
        //截取获得eid的数组
        String str=ids.substring(8,ids.length()-2);
        //分割获得选中的eid
        String res[]=str.split(",");
        Set<Emp> set=new HashSet<Emp>();
        for (int i=0;i<res.length;i++){
            Emp emp=new Emp();
            emp.setEid(res[i]);
            set.add(emp);
        }
        return EmpService.deleteEmp(set);
    }


    //添加雇员信息
    @RequestMapping("addEmpDeatils")
    public ModelAndView addEmpDeatils(Emp emp, MultipartFile file){
        ModelAndView md=new ModelAndView();
        System.out.println(emp.toString());
        String fileExt=null;
        if ("image/jpeg".equals(file.getContentType())||"image/png".equals(file.getContentType())){
            fileExt="jpg";
        }
        //组图片保存路径
        String outPath="D:\\IdeaProjects\\businessTravelProject\\web\\Upload\\"+"!"+ UUID.randomUUID()+"."+fileExt;
        try {
            file.transferTo(new File(outPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //拼凑可以准确查到图片地址的路径
        emp.setPhoto("Upload/!"+outPath.split("!")[1]);
        emp.setHiredate(new Date());
        emp.setLocked(0);
        if (EmpService.InsertEmp(emp)) {
            md.setViewName("/Emp-add-success.jsp");
        }
        return null;
    }

   @RequestMapping("Test")
   public ModelAndView Test(){
      ModelAndView md=new ModelAndView();
      String eid="4";
      Emp emp=new Emp();
      emp.setEid(eid);
      Map<String,Object> map=EmpService.findRoleAndActionByEmp(emp);
      Set<String> set=(Set<String>) map.get("roles");
        String str=set.toString();
        int i=set.toString().length();
       System.out.println(i);
       System.out.println(str);
       String a=new String("financemanager");
       if ("financemanager".equals(str)){
           System.out.println("************************");
       }
      Set<String> set1=(Set<String>)map.get("actions");
      md.addObject("test",set);
      md.addObject("test1",set1);
      md.setViewName("/test.jsp");
      return md;

   }
}
