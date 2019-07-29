package com.sheng.Service.back.Impl;


import com.sheng.Dao.*;
import com.sheng.Service.IEmpServiceBack;
import com.sheng.vo.Dept;
import com.sheng.vo.Emp;
import com.sheng.vo.Level;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
public class IEmpServiceBackImpl implements IEmpServiceBack {
    @Resource(name = "IEmpDaoImpl")
    public IEmpDao empDao;
    @Resource(name = "IDeptDaoImpl")
    public IDeptDao DeptDao;
    @Resource(name = "ILevelDaoImpl")
    public ILevelDao LevelDao;
    @Resource(name = "IRoleDaoImpl")
    public IRoleDao roleDao;
    @Resource(name = "IActionDaoImpl")
    public IActionDao actionDao;

    //用于登陆(通过用户名,查找出密码)
    @Override
    public Emp EmpLogin(String eid) {
        Emp emp=empDao.findEmpByEid(eid);
        return emp;
    }

    @Override
    public Map<String, Object> getDeatiByeid(String eid) {
        Map<String,Object> map=new HashMap<String,Object>();
        Emp emp=empDao.findEmpByEid(eid);
        map.put("EmpDeatil",emp);
        //如果通过id查询返回的雇员详情不为空,那么可以通过其中的eid查询Dept的信息
       if (emp!=null){
           //往map中加入部门的详细信息
           Dept dept=DeptDao.getDeptByEid(emp.getDid());
           map.put("DeptDeatil",dept);
           //往map中加入等级的详细信息
           Level level=LevelDao.findLevelByLid(emp.getLid());
           map.put("Level",level);
       }
       return map;
    }

    @Override
    public boolean UpdateDeptManager(Long did,String eid) {
        //将部门编号为did的部门,领导人的编号清空
        Dept dept=new Dept();
        dept.setDid(did);
        dept.setEid(null);
        if(DeptDao.UpdateDeptManager(dept)){
            //将该领导人的级别由经理降级为雇员
            Emp emp=new Emp();
            emp.setLid("1");
            emp.setEid(eid);
           return empDao.UpdateManager(emp);
        }
      return false;
    }

    @Override
    public Map<String,Object> AllEmp() {
        //查找出全部emp表的信息
       List<Emp> emps= empDao.findAll();
       //查询出全部dept表的信息
       List<Dept> depts=DeptDao.findDeptById();
       //查询出所有职级的信息
       List<Level>levels=LevelDao.findAll();
       Map<String,Object> map=new HashMap<String,Object>();
       map.put("emps",emps);
       map.put("depts",depts);
       map.put("levels",levels);
       return map;
    }

    @Override
    public Map<String, Object> EmpList(String column, String keyword, int linesize, Integer start) {
        List<Level> levels=LevelDao.findAll();
        List<Dept> depts=DeptDao.findDeptById();
        //得到符合条件数据的总数
        int count=empDao.getCount(column,keyword);
        //取得符合条件的数据
        List<Emp> emps=empDao.Limit(column,keyword,linesize,start);
        //将总条数和符合条件的数据放入map中
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("count",count);
        map.put("emps",emps);
        map.put("levels",levels);
        map.put("depts",depts);
        return map;
    }

    @Override
    public boolean EmpEdit(String eid, Long did, String lid, String phone, Integer locked) {
       return  empDao.UpdateEmp(eid,did,lid,phone,locked);
    }

    @Override
    public boolean deleteEmp(Set<Emp> eids) {
        //1.查询出要删除id的信息
        List<Emp> list=empDao.findEmpByIds(eids.toArray());
        //2.迭代查询这些要删除的eid里的雇员是否存在总监和经理
        Iterator<Emp> iter=list.iterator();
        while (iter.hasNext()){
            Emp emp=iter.next();
            //雇员等级为经理
            if ("2".equals(emp.getLid())){
               Emp emp1=new Emp();
               emp1.setEid(emp.getEid());
               emp1.setLid("1");
              if (empDao.UpdateManager(emp1)){
                   emp.setLocked(1);
                   empDao.doLockedEmp(emp);
              }
            }else {
                emp.setLocked(1);
                 empDao.doLockedEmp(emp);
            }
        }
        return true;
    }

    @Override
    public boolean InsertEmp(Emp emp) {
        return empDao.InsertEmp(emp);
    }

    @Override
    public Map<String, Object> findRoleAndActionByEmp(Emp emp) {
        //根据eid查询出详细的lid和eid
        Emp empDeatis=empDao.findRoleByEid(emp);
        Map<String,Object> map=new HashMap<String, Object>();
        Set<String> roles=roleDao.findRoleByEmp(empDeatis);
        Set<String> actions=null;
        //遍历此用户对应的角色,查询这些角色对应的权限
        Iterator<String> iter=roles.iterator();
        while (iter.hasNext()){
            String title=iter.next();
            actions=actionDao.findActionByrole(title);
        }
        map.put("roles",roles);
        map.put("actions",actions);
        return map;
    }
}
