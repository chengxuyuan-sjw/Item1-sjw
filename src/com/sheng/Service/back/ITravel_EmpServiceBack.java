package com.sheng.Service.back;


import com.sheng.vo.Emp;
import com.sheng.vo.Travel_Emp;

import java.util.List;
import java.util.Map;


public interface ITravel_EmpServiceBack {
    /**
     * 查询某项目出差人员
     */
    public List<Emp> findTravelEmp(Long tid);

    /**
     * 增加雇员操作
     */
    public boolean insertTraelEmp(Travel_Emp vo);

    /**
     * 分页查询表中信息
     */
    public Map<String,Object> findAllsplit(String column,String keyword,Integer start,Integer linesize);

}
