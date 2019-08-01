package com.waston.dao;

import com.waston.entity.Book;
import com.waston.uitl.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Waston
 * @Date: 2019/8/1 16:26
 */
public class Bookdao extends JDBCUtils {
    //查询所有书籍
    public List<Book> getAll() throws SQLException {
        List<Book> list = new ArrayList<Book>();
        String sql = "select * from books";

        ResultSet rs = this.executeQuery(sql);
        while (rs.next()){
            try {
                list.add(new Book(rs.getInt(1),
                        rs.getString(2),rs.getDouble(3),
                        rs.getString(4),rs.getDate(5)));
            } catch (SQLException e) {
                System.out.println("查询出错");;
            }
        }
        return list;
    }

    //添加书籍
    public int add(Book b){
        String sql = "insert into books(name,price,author,pubDate) values(?,?,?,?)";
        return this.executeUpdate(sql,b.getName(),b.getPrice(),
                b.getAuthor(),new SimpleDateFormat("yyyy-MM-dd").format(b.getPubDate()));

    }
}
