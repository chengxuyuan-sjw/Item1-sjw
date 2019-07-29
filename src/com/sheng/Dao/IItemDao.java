package com.sheng.Dao;


import com.sheng.vo.Item;

import java.util.List;

public interface IItemDao {
    public List<Item> findAll();
}
