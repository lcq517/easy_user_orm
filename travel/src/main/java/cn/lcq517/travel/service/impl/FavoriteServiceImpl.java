package cn.lcq517.travel.service.impl;

import cn.lcq517.travel.dao.FavoriteDao;
import cn.lcq517.travel.dao.impl.FavoriteDaoImpl;
import cn.lcq517.travel.domain.Favorite;
import cn.lcq517.travel.domain.PageBean;
import cn.lcq517.travel.domain.Route;
import cn.lcq517.travel.service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService
{
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
        return favorite != null;
    }

    @Override
    public int findCountByRid(int rid) {
        return favoriteDao.findCountByRid(rid);
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(rid,uid);
    }

    @Override
    public PageBean<Route> findMyFavorite(int uid, int currentPage, int pageSize) {
        PageBean<Route> pb = new PageBean<Route>();
        //获取该用户的收藏总记录数
        int totalCount = favoriteDao.findTotalCount(uid);
        pb.setTotalCount(totalCount);
        //总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pb.setTotalPage(totalPage);

        int start = (currentPage-1) * pageSize;

        List<Route> routes = favoriteDao.findByPage(uid, start, pageSize);
//        for (Route r :routes) {
//            System.out.println(r.getRname());
//        }
        pb.setList(routes);
        return pb;
    }

}
