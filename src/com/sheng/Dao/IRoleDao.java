package com.sheng.Dao;


import com.sheng.vo.Emp;

import java.util.List;
import java.util.Set;

public interface IRoleDao {
    /**
     * 根据lid,did查询出登陆用户所属角色
     */
    public Set<String> findRoleByEmp(Emp emp);
}
