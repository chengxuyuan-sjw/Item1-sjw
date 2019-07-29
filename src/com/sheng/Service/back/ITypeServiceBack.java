package com.sheng.Service.back;


import com.sheng.vo.Type;

import java.util.List;

public interface ITypeServiceBack {
    /**
     * 查询所有Type表中的信息
     */
    public List<Type> findAllType();
}
