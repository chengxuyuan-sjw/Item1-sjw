package com.sheng.Dao.Impl;


import com.sheng.Dao.ITravelDao;
import com.sheng.vo.Travel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class ITravelDaoImpl implements ITravelDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sessionFactory;

    @Override
    public boolean insert(Travel travel) {
       return sessionFactory.openSession().insert("cn.sheng.vo.Mapping.Travel.doCreat",travel)>0;
    }

    @Override
    public List<Travel> findAllsplit(Map<String, Object> map) {
      List<Travel> list= sessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Travel.findAllSpilt",map);
      return list;
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return sessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Travel.getAllCount",map);
    }

    @Override
    public Travel findTravelById(Travel travel) {
        Travel vo=sessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Travel.findTravelById",travel);
        return vo;
    }

    @Override
    public boolean doUpdate(Travel travel) {
        return sessionFactory.openSession().update("cn.sheng.vo.Mapping.Travel.updateTravel",travel)>0;
    }

    @Override
    public boolean doDelete(Travel travel) {
        return sessionFactory.openSession().delete("cn.sheng.vo.Mapping.Travel.deleteTravel",travel)>0;
    }

    @Override
    public List<Travel> findAll() {
        return sessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Travel.findAll");
    }

    @Override
    public boolean UpdateTotal(Travel travel) {
        return sessionFactory.openSession().update("cn.sheng.vo.Mapping.Travel.UpdateTotal",travel)>0;
    }

    @Override
    public boolean UpdateAutid(Travel travel) {
        return sessionFactory.openSession().update("cn.sheng.vo.Mapping.Travel.UpdateAudit",travel)>0;
    }

    @Override
    public boolean UpdateSubmit(Travel travel) {
        return sessionFactory.openSession().update("cn.sheng.vo.Mapping.Travel.UpdateSubmit",travel)>0;
    }

    @Override
    public List<Travel> findSplitByAudit(Map<String, Object> map) {
        return sessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Travel.findAllSpiltByAudit",map);
    }

    @Override
    public int getCountByAudit(Map<String, Object> map) {
        return sessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Travel.getAllCountByAudit",map);
    }

    @Override
    public boolean UpdateTask(Date date) {
        return sessionFactory.openSession().update("cn.sheng.vo.Mapping.Travel.UpdateTask",date)>0;
    }
}
