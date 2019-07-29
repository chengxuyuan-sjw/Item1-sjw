package com.sheng.Service.back.Impl;


import com.sheng.Dao.ITypeDao;
import com.sheng.Service.back.ITypeServiceBack;
import com.sheng.vo.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ITypeServiceBackImpl implements ITypeServiceBack {
    @Resource(name = "ITypeDaoImpl")
    private ITypeDao typeDao;
    @Override
    public List<Type> findAllType() {
       return typeDao.findAll();
    }
}
