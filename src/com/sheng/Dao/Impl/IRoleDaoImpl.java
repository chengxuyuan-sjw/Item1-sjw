package com.sheng.Dao.Impl;


import com.sheng.Dao.IRoleDao;
import com.sheng.vo.Emp;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class IRoleDaoImpl implements IRoleDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sqlSession;
    @Override
    public Set<String> findRoleByEmp(Emp emp) {
        List<String> list= sqlSession.openSession().selectList("cn.sheng.vo.Mapping.Role.findRoleByEid",emp);
        Set<String> Set = new HashSet<>(list);
        return Set;
    }
}
