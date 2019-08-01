package com.waston.servlet;

import com.waston.dao.Bookdao;
import com.waston.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Description:
 * @Author: Waston
 * @Date: 2019/8/1 17:00
 */
public class ListServlet extends HttpServlet {
    private Bookdao bookdao = new Bookdao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        //ServletOutputStream pw = resp.getOutputStream();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        try {
            List<Book> list = bookdao.getAll();
            pw.print("<html>");
            pw.print("<head>");
            pw.print("<meta charset=\"UTF-8\">");
            pw.print("<title>list</title>");
            pw.print("</head>");
            pw.print("<body>");
            pw.print("<table width = '80%' align='center'>");
            pw.print("<tr>");
            pw.print("<td>");
            pw.print("编号");
            pw.print("</td>");
            pw.print("<td>");
            pw.print("书名");
            pw.print("</td>");
            pw.print("<td>");
            pw.print("价格");
            pw.print("</td>");
            pw.print("<td>");
            pw.print("作者");
            pw.print("</td>");
            pw.print("<td>");
            pw.print("出版日期");
            pw.print("</td>");
            pw.print("</tr>");
            if(list != null)
            for(int i = 0;i < list.size();i++){
                pw.print("<tr>");
                pw.print("<td>");
                pw.print(list.get(i).getId());
                pw.print("</td>");
                pw.print("<td>");
                pw.print(new String(list.get(i).getName().getBytes("iso-8859-1"),"utf-8"));
                pw.print("</td>");
                pw.print("<td>");
                pw.print(list.get(i).getPrice());
                pw.print("</td>");
                pw.print("<td>");
                pw.print(list.get(i).getAuthor());
                pw.print("</td>");
                pw.print("<td>");
                pw.print(new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getPubDate()));
                pw.print("</td>");
                pw.print("</tr>");
            }
            pw.print("</table>");
            pw.print("</body>");
            pw.print("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
