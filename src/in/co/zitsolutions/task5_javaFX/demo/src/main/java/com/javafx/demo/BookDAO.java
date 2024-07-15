package com.javafx.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BookDAO {
    private static Connection conn;
    static {
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","book","book");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert(BookBean book) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into books values(?,?,?,?,?)");
        ps.setInt(1,book.getId());
        ps.setString(2,book.getTitle());
        ps.setString(3,book.getAuthor());
        ps.setInt(4, book.getYear());
        ps.setInt(5, book.getPages());
        ps.executeUpdate();
    }

    public static void update(BookBean book) throws SQLException {
        String qry = "update books set title=?,author=?,year=?,pages=? where id=?";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,book.getTitle());
        ps.setString(2,book.getAuthor());
        ps.setInt(3,book.getYear());
        ps.setInt(4, book.getPages());
        ps.setInt(5, book.getId());
        ps.executeUpdate();
    }

    public static void delete(String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from books where id=?");
        ps.setInt(1,Integer.parseInt(id));
        ps.executeUpdate();
    }

    public static ObservableList<BookBean> selectAll() throws SQLException{
        ObservableList<BookBean> list = FXCollections.observableArrayList();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from books order by id");
        while (rs.next()){
            BookBean book = new BookBean(rs.getInt("id"),rs.getString("title"),rs.getString("author"),rs.getInt("year"),rs.getInt("pages"));
            list.add(book);
        }
        return list;
    }
}
