package cn.lcq517.dao;

import cn.lcq517.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {


    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public int add(User user);

    public int delUser(String id);

    public User findUser(String id);

    public int updateUser(User user);

    public int findUserCount(Map<String, String[]> condtion);

    public List findByPage(int start, int row, Map<String, String[]> condtion);

    public int RegistUser(User user);
}
