package com.sheng.Dao.Impl;

import com.sheng.Dao.ILevelDao;
import com.sheng.vo.Level;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ILevelDaoImpl implements ILevelDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sessionFactory;
    @Override
    public Level findLevelByLid(String lid) {
        Level level=sessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Level.findById",lid);
        return level;
    }

    @Override
    public List<Level> findAll() {
        List<Level> list=new ArrayList<Level>();
        list=sessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Level.findAll");
        return list;
    }
}
