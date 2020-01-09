package cn.lcq517.web.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源
        if (uri.contains("/login.jsp")||uri.contains("/loginServlet")
                ||uri.contains("/css/")||uri.contains("/js/")
                ||uri.contains("/font")||uri.contains("/checkcodeservlet")
                ||uri.contains("/regist.jsp")||uri.contains("/registUserServlet")){
            //包含，用户就是想登录，放行
            chain.doFilter(req, resp);
        }else{
            //不包含，需要验证用户是否需要登录
            //3.从request中获取session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //登录，放行
            chain.doFilter(req, resp);
            }else{
                //没有登陆，跳转登录页面
                request.setAttribute("login_msg","您尚未登录，请先登录!");
                request.getRequestDispatcher("login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
