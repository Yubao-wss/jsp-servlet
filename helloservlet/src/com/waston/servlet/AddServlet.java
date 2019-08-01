package com.waston.servlet;

import com.waston.dao.Bookdao;
import com.waston.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: Waston
 * @Date: 2019/8/1 15:31
 */
public class AddServlet extends HttpServlet {
    private Bookdao bookdao = new Bookdao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//解决中文乱码
        resp.setCharacterEncoding("utf-8");
        //getParameter(表单单元名称)方法，获取用户提交的数据
        String bookName =  req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String author = req.getParameter("author");
        Date pubDate = null;
        try {
            pubDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("pubDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book(bookName,price,author,pubDate);
        if(bookdao.add(book) > 0){
//            resp.setContentType("text/html;charset=utf-8");
            //也可以通过这种方式进行页面跳转
//            resp.getWriter().printf("成功添加"+bookName+"<a href='list'>查询列表</a>");
            //一般用这种方式：重定向
            resp.sendRedirect("list");
        }else {
            resp.getWriter().printf("添加失败！");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
