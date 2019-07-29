package com.sheng.Dao.Impl;


import com.sheng.Dao.ITravel_EmpDao;
import com.sheng.vo.Travel_Emp;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class ITravel_EmpDaoImpl implements ITravel_EmpDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public List<Travel_Emp> findTravelById(Long tid) {
        return sqlSessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Travel_Emp.findAllById",tid);
    }

    @Override
    public boolean insertEmp(Travel_Emp travel_emp) {
        return sqlSessionFactory.openSession().insert("cn.sheng.vo.Mapping.Travel_Emp.insert",travel_emp)>0;
    }

    @Override
    public int getcount(Map<String,Object> map) {
        return sqlSessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Travel_Emp.getAllCount",map);
    }

    @Override
    public List<Travel_Emp> findAllBykeyword(Map<String,Object> map) {
        return sqlSessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Travel_Emp.findAllSpilt",map);
    }
}
