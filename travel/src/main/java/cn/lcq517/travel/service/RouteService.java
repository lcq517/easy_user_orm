package cn.lcq517.travel.service;

import cn.lcq517.travel.domain.PageBean;
import cn.lcq517.travel.domain.Route;

public interface RouteService {
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize ,String rname);

    Route findOne(String rid);

}
