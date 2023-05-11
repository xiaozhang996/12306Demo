package cn.edu.guet;


/**
 * @Author liwei
 * @Date 2023/5/7 10:51
 * @Version 1.0
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        响应JSON
         */
//        response.setContentType("application/json;charset=UTF-8");
//        String weather="{\"status\":\"1\",\"count\":\"1\",\"info\":\"OK\",\"infocode\":\"10000\",\"lives\":[{\"province\":\"北京\",\"city\":\"东城区\",\"adcode\":\"110101\",\"weather\":\"晴\",\"temperature\":\"24\",\"winddirection\":\"北\",\"windpower\":\"≤3\",\"humidity\":\"16\",\"reporttime\":\"2023-05-07 11:39:12\",\"temperature_float\":\"24.0\",\"humidity_float\":\"16.0\"}]}";
//        PrintWriter out=response.getWriter();
//        out.print(weather);
//        out.flush();
//        out.close();
//        点击《查询》后，对后台发请求，那么form表单中的数据：起始站、终点站、出发日期，都被封装到了request中
        String startStation = request.getParameter("startStation");
        System.out.println("起始站：" + startStation);
        String endStation = request.getParameter("endStation");
        System.out.println("终点站："+endStation);

        String departureDate=request.getParameter("departureDate");
        System.out.println("出发日期："+departureDate);

        String ticketList = TicketSearch.search(startStation, endStation, departureDate);

        String json=JSON.toJSONString(ticketList, SerializerFeature.PrettyFormat);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
