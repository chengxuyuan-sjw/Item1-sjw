package com.sheng.Service.back.Impl;

import com.sheng.Dao.IItemDao;
import com.sheng.Dao.ITravelDao;
import com.sheng.Service.back.ITravelServiceBack;
import com.sheng.vo.Travel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ITravelServiceBackImpl implements ITravelServiceBack {
    @Resource(name = "ITravelDaoImpl")
    private ITravelDao travelDao;
    @Resource(name = "IItemDaoImpl")
    private IItemDao iItemDao;
    @Override
    public boolean creatTravel(Travel travel) {
       return travelDao.insert(travel);
    }

    @Override
    public Map<String, Object> findAllTravel(String seid,String column, String keyword, Integer start, Integer linesize) {
        Map<String,Object> map=new HashMap<String, Object>();
        if ("".equals(column)||column==null) {
            map.put("column", null);
        }else {
            map.put("column", column);
        }
        if ("".equals(keyword)||keyword==null) {
            map.put("keyword", null);
        }else {
            map.put("keyword", "%"+keyword+"%");
        }
        if ("".equals(start)||start==null){
            map.put("start",0);
        }else {
            map.put("start", (start - 1) * linesize);
        }

        if ("".equals(seid)||seid==null) {
            map.put("seid", null);
        }else {
            map.put("seid",seid);
        }

        map.put("linesize",linesize);
        map.put("seid",seid);

        //获得符合条件记录的数量
        Integer i=travelDao.getCount(map);
        //获得数据详情
        List<Travel> list=travelDao.findAllsplit(map);
        Map<String,Object> TravelDeatils=new HashMap<String, Object>();
        TravelDeatils.put("travels",list);
        TravelDeatils.put("count",i);
        return TravelDeatils;
    }

    @Override
    public boolean UpdateTravel(Travel travel) {
        return travelDao.doUpdate(travel);
    }

    @Override
    public Travel findDeatilsById(Travel travel) {
        return travelDao.findTravelById(travel);
    }

    @Override
    public boolean DeleteTravel(Travel travel) {
        return travelDao.doDelete(travel);
    }

    @Override
    public List<Travel> findAll() {
        return travelDao.findAll();
    }

    @Override
    public boolean UpdateAutid(Travel travel) {
        return travelDao.UpdateAutid(travel);
    }

    @Override
    public boolean UpdateSubmit(Travel travel) {
        return travelDao.UpdateSubmit(travel);
    }

    @Override
    public Map<String, Object> findSplitByAudit(String column, String keyword, Integer start, Integer linesize,String audit) {
        Map<String,Object> map=new HashMap<String, Object>();
        Map<String,Object> map1=new HashMap<String, Object>();
        if (column==null||"".equals(column)){
            map.put("column",null);
        }else {
            map.put("column",column);
        }
        if (keyword==null||"".equals(column)){
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
        map.put("audit",audit);
        int count= travelDao.getCountByAudit(map);
        List<Travel> travels=travelDao.findSplitByAudit(map);
        map1.put("travels",travels);
        map1.put("count",count);
        return map1;
    }

    @Override
    public boolean UpdateTask(Date date) {
        return travelDao.UpdateTask(date);
    }
}
