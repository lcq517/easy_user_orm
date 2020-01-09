package cn.lcq517.travel.dao.impl;

import cn.lcq517.travel.dao.FavoriteDao;
import cn.lcq517.travel.domain.Favorite;
import cn.lcq517.travel.domain.Route;
import cn.lcq517.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),rid,uid);
        } catch (DataAccessException e) {
            //e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public int findCountByRid(int rid) {
        String sql = "select count(*) from tab_favorite where rid = ?";
        return template.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public void add(String rid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?)";

        int update = template.update(sql, rid, new Date(), uid);
        System.out.println(update);
    }

    @Override
    public int findTotalCount(int uid) {
        //1.定义sql模板
        String sql = "select count(*) from tab_favorite where uid = ?  ";
        return template.queryForObject(sql,Integer.class,uid);
    }



    @Override
    public List<Route> findByPage(int uid, int start, int pageSize) {
        //String sql = "select * from tab_route where cid = ? limit ?,?";
        String sql = "SELECT * FROM tab_route AS r " +
                "RIGHT JOIN " +
                "(SELECT rid AS frid FROM tab_favorite  WHERE uid = ?) AS f " +
                "ON r.rid = f.frid limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),uid,start,pageSize);
    }
}
