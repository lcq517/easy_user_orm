package cn.lcq517.web.servlet;

import cn.lcq517.domain.PageBean;
import cn.lcq517.service.UserService;
import cn.lcq517.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage==null){
            currentPage = "1";
        }
        if (rows==null){
            rows = "5";
        }
        //获取条件查询参数
        Map<String, String[]> condtion = request.getParameterMap();

        UserService service = new UserServiceImpl();
        PageBean pb = service.findUserByPageService(currentPage,rows,condtion);
        request.setAttribute("PageBean",pb);
        request.setAttribute("condition",condtion);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
