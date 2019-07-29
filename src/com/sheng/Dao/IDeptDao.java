package com.sheng.Dao;


import com.sheng.vo.Dept;

import java.util.List;

public interface IDeptDao {
    public List<Dept> findDeptById();

    /**
     * 完成页面部门名称修改的操作,根据did修改dname
     * @param dept
     * @return
     */
    public boolean doUpdate(Dept dept);

    /**
     * 完成BootStrap模态框,通过id获得部门详情
     * @param did
     * @return
     */
    public Dept getDeptByEid(Long did);

    /**
     * 根据部门编号,更新领导信息
     */

    public boolean UpdateDeptManager(Dept dept);

}
