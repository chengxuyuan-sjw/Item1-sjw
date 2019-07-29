package com.sheng.Dao.Impl;


import com.sheng.Dao.IEmpDao;
import com.sheng.vo.Emp;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class IEmpDaoImpl implements IEmpDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sqlSession;
    /**
     * 返回所有Emp的信息
     * @return
     */
    @Override
    public List<Emp> findAllManager() {
        List<Emp> list=new ArrayList<Emp>();
        list=sqlSession.openSession().selectList("cn.sheng.vo.Mapping.Emp.findAllManager");
        return list;
    }

    @Override
    public Emp findEmpByEid(String eid) {
       Emp emp=sqlSession.openSession().selectOne("cn.sheng.vo.Mapping.Emp.findAllById",eid);
        return emp;
    }

    @Override
    public boolean UpdateManager(Emp emp) {
       int i= sqlSession.openSession().update("cn.sheng.vo.Mapping.Emp.UpdateLid",emp);
       return i>0;

    }

    @Override
    public List<Emp> findAll() {
        List<Emp> list=new ArrayList<Emp>();
        list=sqlSession.openSession().selectList("cn.sheng.vo.Mapping.Emp.findAll");
        return list;
    }

    @Override
    public Integer getCount(String column, String keyword) {
        Map<String,Object> map=new HashMap<String, Object>();
        if("".equals(column)||column==null){
            map.put("column",null);
        }else {
            map.put("column",column);
        }

        if ("".equals(keyword)||column==null){
            map.put("keyword",null);
        }else {
            map.put("keyword","%"+keyword+"%");
        }
        return sqlSession.openSession().selectOne("cn.sheng.vo.Mapping.Emp.getAllCount",map);
    }


    @Override
    public List<Emp> Limit(String column, String keyword, int linesize, Integer start) {
        Map<String, Object> map = new HashMap<String, Object>();
        if ("".equals(column) || column == null) {
            map.put("column", null);
        } else {
            map.put("column", column);
        }

        if ("".equals(keyword) || column == null) {
            map.put("keyword", null);
        } else {
            map.put("keyword", "%"+keyword+"%");
        }

        if ("".equals(start)||start==null){
            map.put("start",0);
        }else {
            map.put("start",(start-1)*linesize);
        }
        map.put("linesize",linesize);
        return sqlSession.openSession().selectList("cn.sheng.vo.Mapping.Emp.findAllSplit",map);
    }

    @Override
    public boolean UpdateEmp(String eid, Long did, String lid, String phone, Integer locked) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("eid",eid);
        map.put("did",did);
        map.put("lid",lid);
        map.put("phone",phone);
        map.put("locked",locked);
        return sqlSession.openSession().update("cn.sheng.vo.Mapping.Emp.UpdateEmp",map)>0;
    }

    @Override
    public boolean doLockedEmp(Emp emp) {
        return sqlSession.openSession().update("cn.sheng.vo.Mapping.Emp.UpdateLocked",emp)>0;
    }

    @Override
    public List<Emp> findEmpByIds(Object eids[]) {
        List<Emp> list=new ArrayList<Emp>();
        list=sqlSession.openSession().selectList("cn.sheng.vo.Mapping.Emp.findEmpByIds",eids);
        return list;
    }

    @Override
    public boolean InsertEmp(Emp emp) {
        return sqlSession.openSession().insert("cn.sheng.vo.Mapping.Emp.doCreatEmp",emp)>0;
    }

    @Override
    public Emp findRoleByEid(Emp emp) {
        return sqlSession.openSession().selectOne("cn.sheng.vo.Mapping.Emp.findLidAndDidByEid",emp);
    }

}
