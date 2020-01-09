package cn.lcq517.service;

import cn.lcq517.domain.PageBean;
import cn.lcq517.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    public User login(User user);

    public int add(User user);

    public int delUser(String id);

    public User findUser(String id);

    public int updateUser(User user);

    public void delSelectUser(String[] selectIds);

    public PageBean findUserByPageService(String currentPage, String rows, Map<String, String[]> condtion);

    public int RegistUserService(User user);
}
