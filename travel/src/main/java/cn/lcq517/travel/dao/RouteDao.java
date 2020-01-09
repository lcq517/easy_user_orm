package cn.lcq517.travel.dao;

import cn.lcq517.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 根据cid查询总记录数
     */
    public int findTotalCount(int cid,String rname);

    /**
     * 根据cid start pageSize查询当前的数据集合
     */
    public List<Route> findByPage(int cid , int start, int pageSize,String rname);

    Route findOne(int parseInt);
}
