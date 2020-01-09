package cn.lcq517.travel.service.impl;

import cn.lcq517.travel.dao.UserDao;
import cn.lcq517.travel.dao.impl.UserDaoImpl;
import cn.lcq517.travel.domain.User;
import cn.lcq517.travel.service.UserService;
import cn.lcq517.travel.util.MailUtils;
import cn.lcq517.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.finByUsername(user.getUsername());
        //2.保存用户信息
        if (u != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活状态
        user.setStatus("N");
        //2.2设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        userDao.save(user);

        //3.激活邮件发送，邮件正文?
        String conntent="<p><a href=\" http:localhost/travel/user/active?code="+user.getCode()+"\" rel=\"noopener\" target=\"_blank\">点击激活【黑马旅游网】</a></p>";
        System.out.println(conntent);
        MailUtils.sendMail(user.getEmail(),conntent,"激活邮件");
        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user != null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

}
