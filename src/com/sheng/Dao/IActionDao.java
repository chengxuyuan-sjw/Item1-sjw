package com.sheng.Dao;

import java.util.Set;

public interface IActionDao {
    /**
     *根据角色信息查询角色对应的权限
     */
    public Set<String> findActionByrole(String title);
}
