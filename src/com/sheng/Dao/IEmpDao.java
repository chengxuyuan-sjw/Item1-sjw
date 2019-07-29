package com.sheng.Dao;


import com.sheng.vo.Emp;

import java.util.List;
import java.util.Map;

public interface IEmpDao {

    /**
     * 查询出所有部门的领导信息
     * @return
     */
    public List<Emp> findAllManager();

    /**
     * 通过ename查询完整信息
     */

    public Emp findEmpByEid(String eid);

    /**
     * 完成领导降级任务,根据eid编号,修改lid的等级
     * @return
     */
    public boolean UpdateManager(Emp emp);


    /**
     * 查询出emp表中所有的数据
     */
    public List<Emp> findAll();


    /**
     * 通过查询出模糊查询后的符合条件的雇员信息数量
     */

    public Integer getCount(String conlumn,String keyword);


    /**
     * 分页+模糊查询
     */

    public List<Emp> Limit(String conlumn,String keyword,int linesize,Integer start);

    /**
     * 更新雇员信息
     */
    public boolean UpdateEmp(String eid,Long did,String lid,String phone,Integer locked);


    /**
     * 删除雇员(锁定雇员状态)
     */
    public boolean doLockedEmp(Emp emp);


    /**
     * 批量查询多个雇员信息
     */
    public List<Emp> findEmpByIds(Object eid[]);

    /**
     * 新增雇员操作
     */
     public boolean InsertEmp(Emp emp);


    /**
     * 根据eid查询出部门编号和等级编号
     */
     public Emp findRoleByEid(Emp emp);

}

