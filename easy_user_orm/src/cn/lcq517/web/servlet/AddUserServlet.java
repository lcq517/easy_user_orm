package cn.lcq517.web.servlet;

import cn.lcq517.domain.User;
import cn.lcq517.service.UserService;
import cn.lcq517.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //2.获取所有数据
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        User user = null;
        try {
            user = new User();
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        int count = service.add(user);
        if (count > 0 ){
            //添加成功
            response.getWriter().write("<script>alert('添加成功')</script>");
            List<User> users = service.findAll();
            request.setAttribute("users",users);
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
        }else{
            //添加失败
            response.getWriter().write("<script>alert('添加失败')</script>");
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
