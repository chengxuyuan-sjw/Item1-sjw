package com.sheng.Dao.Impl;


import com.sheng.Dao.ITypeDao;
import com.sheng.vo.Type;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class ITypeDaoImpl implements ITypeDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sessionFactory;
    @Override
    public List<Type> findAll() {
        return sessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Type.findAll");
    }
}
