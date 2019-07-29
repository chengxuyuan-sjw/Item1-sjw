package com.sheng.Dao.Impl;

import com.sheng.Dao.IItemDao;
import com.sheng.vo.Item;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class IItemDaoImpl implements IItemDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sessionFactory;
    @Override
    public List<Item> findAll() {
       return sessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Item.findAll");
    }
}
