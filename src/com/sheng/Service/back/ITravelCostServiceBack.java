package com.sheng.Service.back;

import com.sheng.vo.TravelCost;

import java.util.List;
import java.util.Map;

public interface ITravelCostServiceBack {
    /**
     * 1.增加当前所输入的费用
     * 2.更新此tid记录里total的总费用
     */
    public boolean UpdateTotalAndCost(TravelCost travelCost);

    /**
     * 查询出当前tid内的所有费用单项选择
     */
    public List<TravelCost> findListById(TravelCost travelCost);

    /**
     * 1.删除某项差旅费用
     * 2.更新当前total
     */
    public boolean deleteById(TravelCost travelCost);

    /**
     * 获得当前申请总费用
     */

    public Double getCount(TravelCost travelCost);

    /**
     * 判断travel_cost是否存在新建tid的数据,不存在则创建tid
     */
    public boolean hasTid(TravelCost travelCost);
}
