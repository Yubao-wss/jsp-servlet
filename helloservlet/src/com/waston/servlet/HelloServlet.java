package com.waston.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Description:
 * @Author: Waston
 * @Date: 2019/7/29 17:53
 */
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException
    {
        // 初始化
        message = "Hello, First Servlet!你好";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置:响应内容类型
        response.setContentType("text/html");

        // 输出文本
        PrintWriter out = response.getWriter();
        out.write("<h1> " + message + " </h1>");
        //获取请求标签头
        String context = request.getContextPath();
        System.out.println(context);

        System.out.println("Host:"+request.getHeader("Host"));
        /*
            结果：
            Host:localhost:8866
                (获取到了http请求头)
        */

        Enumeration<String> enums = request.getHeaderNames();
        while(enums.hasMoreElements()){
            String en = enums.nextElement();
            System.out.println(en);
        }
        /*
            结果：
            host
            connection
            upgrade-insecure-requests
            user-agent
            accept
            accept-encoding
            accept-language
            cookie
        */

        System.out.println("请求方法名 "+request.getMethod());
        /*
            结果：
            请求方法名 GET
        */
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        /*
            结果：
            /hello
            http://localhost:8866/hello
        */

        //获取远程访问者的id（用于投票、访问量、屏蔽指定用户、定点攻击）
        System.out.println(request.getRemoteAddr());
        //获取远程访问者的主机名
        System.out.println(request.getRemoteHost());
        /*
            结果：
            0:0:0:0:0:0:0:1
            0:0:0:0:0:0:0:1
        */
    }

}

