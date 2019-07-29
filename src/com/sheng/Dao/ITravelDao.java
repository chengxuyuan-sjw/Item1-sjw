package com.sheng.Dao;


import com.sheng.vo.Travel;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ITravelDao {
    /**
     * 设置添加方法
     * @param travel
     * @return
     */
    public boolean insert(Travel travel);

    /**
     * 设置模糊查询且分页的个人申请列表数据
     */
    public List<Travel> findAllsplit(Map<String,Object> map);

    /**
     * 查询出符合条件的数据的数目
     */
    public Integer getCount(Map<String,Object> map);

    /*通过tid查询出该条申请记录信息*/

    public Travel findTravelById(Travel travel);


    /*更新主要数据,用户重新编辑提交情况*/

    public boolean doUpdate(Travel travel);


    /*删除指定条数的信息,前提必须状态是9或2(审核中,或者是被拒绝)*/

    public boolean doDelete(Travel travel);

    /*查询出travel全部数据*/
    public List<Travel> findAll();

    /**
     * 更新总费用
     */
   public boolean UpdateTotal(Travel travel);


    /**
     * 审批状态,更新订单状态和审核日期
     */
    public boolean UpdateAutid(Travel travel);

    /**
     * 状态变更,由未提交变成审核中状态
     */
    public boolean UpdateSubmit(Travel travel);


    /**
     * 根据当前状态查询所有的数据
     */
    public List<Travel> findSplitByAudit(Map<String,Object> map);

    /**
     * 根据指定的状态查询符合条件数据的数量
     */
    public int getCountByAudit(Map<String,Object> map);

    /**
     * 定时更新状态,更新状态到3,表示已完成出差
     */
    public boolean UpdateTask(Date date);
}
