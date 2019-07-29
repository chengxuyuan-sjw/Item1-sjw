package com.sheng.Service;


import com.sheng.vo.Emp;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IEmpServiceBack {
    /**
     * 用于通过eid查询数据库,返回此eid包括密码等完整的信息以便shiro框架进行验证
     * @return
     */
    public Emp EmpLogin(String eid);

    /**
     * 通过eid,获得详细的雇员信息,以及部门信息
     * @return
     */
    public Map<String,Object> getDeatiByeid(String eid);


    /**
     * 获取页面部门信息,将领导信息清空,并且,将此为领导雇员的lid降级
     * 以便完成领导降级工作
     */
    public boolean UpdateDeptManager(Long did,String eid);

    /**
     * 查找出全部emp表的信息
     */
    public Map<String,Object> AllEmp();

    /**
     * 数据结构+分页查询,完成雇员列表基本功能
     */

    public Map<String,Object> EmpList(String column,String keyword,int linesize,Integer start);

    /**
     * 定义更新操作业务层
     */

    public boolean EmpEdit(String eid,Long did,String lid,String phone,Integer locked);

    /**
     * 定义删除操作
     * 1.更新指定用户状态为锁定
     * 2.查询删除雇员信息是否为部门,如果为部门领导必须先执行降级操作
     */

    public boolean deleteEmp(Set<Emp> eids);

    /**
     * 新增新雇员
     */
    public boolean InsertEmp(Emp emp);


    /**
     * 根据登陆雇员信息查询出对应的权限和角色
     */
    public Map<String,Object> findRoleAndActionByEmp(Emp emp);
}
