package com.sheng.Service.back;


import com.sheng.vo.Travel;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ITravelServiceBack {
    /**
     * 用于创建差旅订单
     * 1.添加表中信息到Travel信息,因为提交后是未审核的所以状态为9
     * @return
     */
    public boolean creatTravel(Travel travel);

    /**
     * 查询个人申请记录的列表
     * 1.查询出符合数据的总记录数
     * 2.查询出数组的详细情况
     */

    public Map<String, Object> findAllTravel(String seid,String column,String keyword,Integer start,Integer linesize);

   /* *
     * 承接重新编辑申请单的任务
     * 接收提交的内容,进行更新*/

    public boolean UpdateTravel(Travel travel);

    /**
     * 用于查询出指定tid的数据信息,然后反馈到网站底层
     */
    public Travel findDeatilsById(Travel travel);

    /**
     * 根据接收到id删除状态为9或者2的申请信息*/

    public boolean DeleteTravel(Travel travel);

    /**
     * 查询出travel表中的全部数据
     */
    public List<Travel> findAll();

    /**
     * 审批申请
     * 1.更新autid的状态
     * 2.更新审批日期
     */
    public boolean UpdateAutid(Travel travel);


    /**
     * 更新状态
     * 1.由未提交变成审核中
     */
    public boolean UpdateSubmit(Travel travel);


    /**
     * 根据状态模糊查询数据
     * 1.查询所有符合此状态的数据集合
     * 2.查询出符合条件数据的个数
     */
    public Map<String,Object> findSplitByAudit(String column,String keyword,Integer start,Integer linesize,String audit);


    /**
     * 定时更新状态,当当前日期大于出差结束日期,那么出差状态设置为已完成
     */
    public boolean UpdateTask(Date date);
}
