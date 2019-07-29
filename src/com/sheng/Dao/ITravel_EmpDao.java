package com.sheng.Dao;


import com.sheng.vo.Travel_Emp;

import java.util.List;
import java.util.Map;

public interface ITravel_EmpDao {
    /**
     * 根据tid,查询全部信息
     */

    public List<Travel_Emp> findTravelById(Long tid);


    /**
     * 插入出差人员
     */
    public boolean insertEmp(Travel_Emp travel_emp);

    /**
     * 查询出符合条件的总条数
     */

    public int getcount(Map<String,Object> map);

    /**
     * 模糊查询
     */
    public List<Travel_Emp> findAllBykeyword(Map<String,Object> map);

}
