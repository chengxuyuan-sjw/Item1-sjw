package com.sheng.Dao.Impl;


import com.sheng.Dao.IDeptDao;
import com.sheng.vo.Dept;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class IDeptDaoImpl implements IDeptDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    /**
     * 返回所有部门信息
     * @return
     */
    @Override
    public List<Dept> findDeptById() {
        List<Dept> list=new ArrayList<Dept>();
        list=sqlSessionFactory.openSession().selectList("cn.sheng.vo.Mapping.Dept.findAll");
        return list;
    }

    public boolean doUpdate(Dept dept){
        int i=sqlSessionFactory.openSession().update("cn.sheng.vo.Mapping.Dept.doUpate",dept);
        return i>0;
    }

    @Override
    public Dept getDeptByEid(Long did) {
        Dept dept=sqlSessionFactory.openSession().selectOne("cn.sheng.vo.Mapping.Dept.findAllById",did);
        return dept;
    }

    @Override
    public boolean UpdateDeptManager(Dept dept) {
        int i=sqlSessionFactory.openSession().update("cn.sheng.vo.Mapping.Dept.doDeptManager",dept);
        return i>0;
    }
}
