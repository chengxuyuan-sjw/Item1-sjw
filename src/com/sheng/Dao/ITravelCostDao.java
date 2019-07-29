package com.sheng.Dao;


import com.sheng.vo.TravelCost;

import java.util.List;

public interface ITravelCostDao {
    /**
     * 增加单项费用信息
     */
    public boolean insertTotal(TravelCost travelCost);

    /**
     * 根据tid查询total总计
     */
    public double sumTotal(TravelCost travelCost);

    /**
     * 根据tid,查询该申请的费用详情
     */
    public List<TravelCost> findAllById(TravelCost travelCost);

    /**
     * 根据tcid删除某项的数据
     */
    public boolean deleteTravelCost(TravelCost travelCost);


    /**
     * 查询某tid的数据条数
     */
    public int getCountById(TravelCost travelCost);
}
