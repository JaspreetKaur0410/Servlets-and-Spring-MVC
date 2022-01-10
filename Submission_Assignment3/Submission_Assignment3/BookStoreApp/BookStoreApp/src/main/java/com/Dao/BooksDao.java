/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Dao;

import com.Bean.BooksBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author jaspr
 */
public class BooksDao {
    
    public static Logger logger = Logger.getLogger("global");
    private String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
    private String username = "root";
    private String password = "";
    private String jdbcDriver = "com.mysql.jdbc.Driver";
    
    private static final String INSERT_BOOK = "INSERT INTO books" + "  (isbn, title, author,price) VALUES "
            + " (?, ?, ?,?);";
    private static final String SELECT_ALL_BOOKS = "select * from books";
    
    public BooksDao(){
        
    }
    
    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(jdbcURL, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insertBook(BooksBean book) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_BOOK);
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public List<BooksBean> selectAllBooks() {

        List<BooksBean> movies = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String price = rs.getString("price");
                movies.add(new BooksBean(isbn, title, author, Double.parseDouble(price)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return movies;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    
}
