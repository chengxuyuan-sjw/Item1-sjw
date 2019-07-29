package com.sheng.Service.back.Impl;


import com.sheng.Dao.IDeptDao;
import com.sheng.Dao.IEmpDao;
import com.sheng.Service.back.IDeptServiceBack;
import com.sheng.vo.Dept;
import com.sheng.vo.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IDeptServiceBackImpl implements IDeptServiceBack {
    @Resource(name = "IDeptDaoImpl")
    private IDeptDao DeptDao;
    @Resource(name = "IEmpDaoImpl")
    private IEmpDao EmpDao;

    @Override
    public Map<String, Object> list() {
        Map<String,Object> map=new HashMap<String,Object>();
        //获取所有部门信息
        List<Dept> AllDept=DeptDao.findDeptById();
        //获取所有部门的员工信息
        List<Emp> AllEmp=EmpDao.findAllManager();
        map.put("AllDept",AllDept);
        map.put("AllEmp",AllEmp);
        return map;
    }

    @Override
    public boolean UpdateDname(Dept dept) {
        return DeptDao.doUpdate(dept);
    }


}
