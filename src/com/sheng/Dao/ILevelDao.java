package com.sheng.Dao;


import com.sheng.vo.Level;

import java.util.List;

public interface ILevelDao {
    /**
     * 根据id查询出职级信息
     * @param lid
     * @return
     */
    public Level findLevelByLid(String lid);

    /**
     * 查询出职位全部信息
     * @return
     */
    public List<Level> findAll();
}
