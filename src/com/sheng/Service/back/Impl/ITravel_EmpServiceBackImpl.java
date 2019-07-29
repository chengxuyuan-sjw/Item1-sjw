package com.sheng.Service.back.Impl;

import com.sheng.Dao.IEmpDao;
import com.sheng.Dao.ITravel_EmpDao;
import com.sheng.Service.back.ITravel_EmpServiceBack;
import com.sheng.vo.Emp;
import com.sheng.vo.Travel_Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ITravel_EmpServiceBackImpl implements ITravel_EmpServiceBack {
    @Resource(name = "ITravel_EmpDaoImpl")
    private ITravel_EmpDao travel_empDao;
    @Resource(name ="IEmpDaoImpl")
    private IEmpDao empDao;
    @Override
    public List<Emp> findTravelEmp(Long tid) {
        //1.查询出此项目对应的出差人员id
        List<Travel_Emp> tids=travel_empDao.findTravelById(tid);
        //2.查询这些ids对应的雇员信息
        List<Emp> emps=empDao.findEmpByIds(tids.toArray());
        //3.将信息加入Map集合中
        return emps;
    }

    @Override
    public boolean insertTraelEmp(Travel_Emp vo) {
        return travel_empDao.insertEmp(vo);
    }

    @Override
    public Map<String, Object> findAllsplit(String column, String keyword, Integer start, Integer linesize) {
         Map<String,Object> map=new HashMap<String,Object>();
         if ("".equals(column)||column==null){
             map.put("column",null);
         }else {
             map.put("column",column);
         }
         if ("".equals(keyword)||keyword==null){
             map.put("keyword",null);
         }else {
             map.put("keyword",keyword);
         }
         if ("".equals(start)||start==null){
             map.put("start",0);
         }else {
             map.put("start",(start-1)*linesize);
         }
         map.put("linesize",linesize);
         List<Travel_Emp> list=travel_empDao.findAllBykeyword(map);
         int count=travel_empDao.getcount(map);
         Map<String,Object> map1=new HashMap<String, Object>();
         map1.put("travelEmps",list);
         map1.put("count",count);
         return map1;
    }
}
