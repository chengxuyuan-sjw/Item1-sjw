package com.sheng.Service.back;

import com.sheng.vo.Item;

import java.util.List;

public interface IItemServiceBack {
    /**
     * 查询出差类型的详细情况
     */
    public List<Item> getDeatils();
}
