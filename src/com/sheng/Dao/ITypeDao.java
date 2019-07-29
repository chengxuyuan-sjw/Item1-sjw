package com.sheng.Dao;



import com.sheng.vo.Type;

import java.util.List;

public interface ITypeDao {
    /**
     * 查询费用类型表全部信息
     */
    public List<Type> findAll();
}
