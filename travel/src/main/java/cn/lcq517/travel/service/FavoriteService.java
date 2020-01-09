package cn.lcq517.travel.service;

import cn.lcq517.travel.domain.PageBean;
import cn.lcq517.travel.domain.Route;

public interface FavoriteService {
    /**
     * 判断是否收藏
     */
    public boolean isFavorite(String rid, int uid);

    /**
     * 根据rid 查询收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    public void add(String rid, int uid);

    public PageBean<Route> findMyFavorite(int uid, int currentPage, int pageSize);
}
