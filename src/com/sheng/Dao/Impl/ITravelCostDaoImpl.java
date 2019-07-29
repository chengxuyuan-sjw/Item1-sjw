package com.sheng.Dao.Impl;


import com.sheng.Dao.ITravelCostDao;
import com.sheng.vo.TravelCost;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ITravelCostDaoImpl implements ITravelCostDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sessionFactory;
    @Override
    public boolean insertTotal(TravelCost travelCost) {
        return sessionFactory.openSession().insert("cn.sheng.vo.Mapping.Travel_Cost.insertCost",travelCost)>0;
    }

    @Override
    public double sumTotal(TravelCost travelCost) {
        return sessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Travel_Cost.findSumById",travelCost);
    }

    @Override
    public List<TravelCost> findAllById(TravelCost travelCost) {
        return sessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Travel_Cost.findAllById",travelCost);
    }

    @Override
    public boolean deleteTravelCost(TravelCost travelCost) {
        return sessionFactory.openSession().delete("cn.sheng.vo.Mapping.Travel_Cost.deleteById",travelCost)>0;
    }

    @Override
    public int getCountById(TravelCost travelCost) {
        return sessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Travel_Cost.getTidCount",travelCost);
    }
}
