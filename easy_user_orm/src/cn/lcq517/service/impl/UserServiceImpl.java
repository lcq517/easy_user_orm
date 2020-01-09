package cn.lcq517.service.impl;

import cn.lcq517.dao.UserDao;
import cn.lcq517.dao.impl.UserDaoImpl;
import cn.lcq517.domain.PageBean;
import cn.lcq517.domain.User;
import cn.lcq517.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int delUser(String id) {
        return dao.delUser(id);
    }

    @Override
    public User findUser(String id) {
        return dao.findUser(id);
    }

    @Override
    public int updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public void delSelectUser(String[] selectIds) {
        for (String id:selectIds) {
            dao.delUser(id);
        }

    }

    @Override
    public PageBean findUserByPageService(String currentPage, String rows, Map<String, String[]> condtion) {
        PageBean pb = new PageBean();
        pb.setTotalCount(dao.findUserCount(condtion));
        int totalCount = pb.getTotalCount();
        int row = Integer.parseInt(rows);
        int totalPage;
        if((totalCount % row) == 0 ){
            totalPage = totalCount / row;
        }else {
            totalPage = totalCount / row + 1;
        }
        pb.setTotalPage(totalPage);
        pb.setCurrentPage(Integer.parseInt(currentPage));
        int start = (Integer.parseInt(currentPage)-1) * row;
        pb.setList(dao.findByPage(start , row,condtion));
        return pb;
    }

    @Override
    public int RegistUserService(User user) {
        return dao.RegistUser(user);
    }

}
