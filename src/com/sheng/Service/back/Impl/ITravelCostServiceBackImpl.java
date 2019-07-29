package com.sheng.Service.back.Impl;

import com.sheng.Dao.IItemDao;
import com.sheng.Dao.ITravelCostDao;
import com.sheng.Dao.ITravelDao;
import com.sheng.Service.back.ITravelCostServiceBack;
import com.sheng.vo.Travel;
import com.sheng.vo.TravelCost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ITravelCostServiceBackImpl implements ITravelCostServiceBack {
    @Resource(name = "ITravelDaoImpl")
    private ITravelDao travelDao;
    @Resource(name = "IItemDaoImpl")
    private IItemDao iItemDao;
    @Resource(name = "ITravelCostDaoImpl")
    private ITravelCostDao travelCostDao;
    @Override
    public boolean UpdateTotalAndCost(TravelCost travelCost) {
        if (travelCostDao.insertTotal(travelCost)){
            double total=travelCostDao.sumTotal(travelCost);
            Travel vo=new Travel();
            vo.setTotal(total);
            vo.setTid(travelCost.getTid());
            if (travelDao.UpdateTotal(vo)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TravelCost> findListById(TravelCost travelCost) {
        return travelCostDao.findAllById(travelCost);
    }

    @Override
    public boolean deleteById(TravelCost travelCost) {
        if (travelCostDao.deleteTravelCost(travelCost)){
            double total=travelCostDao.sumTotal(travelCost);
            Travel vo=new Travel();
            vo.setTotal(total);
            vo.setTid(travelCost.getTid());
            if (travelDao.UpdateTotal(vo)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Double getCount(TravelCost travelCost) {
        return travelCostDao.sumTotal(travelCost);
    }

    @Override
    public boolean hasTid(TravelCost travelCost) {
        if (travelCostDao.getCountById(travelCost)==0){
            //当价格为0时候,为空会造成指针错误,所以要赋值0
            travelCost.setPrice(0.0);
           return travelCostDao.insertTotal(travelCost);
        }else {
            return true;
        }
    }


}
