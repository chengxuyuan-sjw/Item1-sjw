package com.sheng.Dao.Impl;


import com.sheng.Dao.IActionDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class IActionDaoImpl implements IActionDao {
    @Resource(name = "sessionFactory")
    private SqlSessionFactory sqlSession;
    @Override
    public Set<String> findActionByrole(String title) {
        List<String> list= sqlSession.openSession().selectList("cn.sheng.vo.Mapping.Action.findActionByRole",title);
        Set<String> roleSet = new HashSet<>(list);
        return roleSet;
    }
}
