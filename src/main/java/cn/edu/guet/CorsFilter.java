package cn.edu.guet;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //允许跨域访问，通过response对象写回一些跨域访问的头信息
        resp.setHeader("Access-Control-Allow-Origin","*");
        //允许请求的方法
        resp.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}