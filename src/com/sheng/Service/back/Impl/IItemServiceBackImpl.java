package com.sheng.Service.back.Impl;


import com.sheng.Dao.IItemDao;
import com.sheng.Service.back.IItemServiceBack;
import com.sheng.vo.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class IItemServiceBackImpl implements IItemServiceBack {
    @Resource(name = "IItemDaoImpl")
    private IItemDao iItemDao;
    @Override
    public List<Item> getDeatils() {
       return iItemDao.findAll();
    }
}
