package cn.lcq517.travel.dao;

import cn.lcq517.travel.domain.Favorite;
import cn.lcq517.travel.domain.Route;

import java.util.List;

public interface FavoriteDao {

    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid  查询收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void add(String rid, int uid);

    public List<Route> findByPage(int uid, int start, int pageSize);

    public int findTotalCount(int uid);
}
