package cn.lcq517.web.servlet;

import cn.lcq517.domain.User;
import cn.lcq517.service.UserService;
import cn.lcq517.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        int count = service.delUser(id);
        if (count != 0){
            List<User> users = service.findAll();
            request.setAttribute("users",users);
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
        }else{

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
