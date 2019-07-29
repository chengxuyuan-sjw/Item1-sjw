package com.sheng.Service.back;


import com.sheng.vo.Dept;

import java.util.Map;

public interface IDeptServiceBack {
    /**
     * 查询出部门所有的信息
     * @return
     * 1.key=allDepts value=部门所有的信息
     * 2.key=allEmps  value=所有领导的集合
     */
    public Map<String,Object> list();

    /**
     * 根据did修改dname,完成页面Ajax异步修改部门名称
     */
    public boolean UpdateDname(Dept dept);
}
