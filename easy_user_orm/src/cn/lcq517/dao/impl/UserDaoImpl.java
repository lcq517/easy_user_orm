package cn.lcq517.dao.impl;

import cn.lcq517.dao.UserDao;
import cn.lcq517.domain.User;
import cn.lcq517.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username=? and password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
            System.out.println(user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int add(User user) {
        String sql = "insert into user(name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
        int count = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
            return count;
    }

    @Override
    public int delUser(String id) {
        String sql = "delete from user where id = ?";
        int count = template.update(sql, id);
        return count;
    }

    @Override
    public User findUser(String id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id = ?";
        int count = template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
        return count;
    }

    @Override
    public int findUserCount(Map<String, String[]> condtion) {
        String sql = "select count(*) from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condtion.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key:keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condtion.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" and " + key+" like ?");
                params.add("%"+value+"%");
            }
        }
        int totalCount = template.queryForObject(sb.toString(),Integer.class,params.toArray());
        return totalCount;
    }

    @Override
    public List findByPage(int start, int row, Map<String, String[]> condtion) {
        String sql = "select * from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condtion.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key:keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condtion.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" and " + key+" like ?");
                params.add("%"+value+"%");
            }
        }
        sb.append( " limit ?,?");
        params.add(start);
        params.add(row);
        List<User> users = template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class),params.toArray());
        return users;
    }

    @Override
    public int RegistUser(User user) {
        String sql = "insert into user(name,gender,age,address,qq,email,username,password) values(?,?,?,?,?,?,?,?)";
        int update = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),
                user.getUsername(), user.getPassword());
       // System.out.println(update);
        return update;
    }


}
