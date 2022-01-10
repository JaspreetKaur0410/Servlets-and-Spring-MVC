/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Movies;
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
public class DAO {

    public static Logger logger = Logger.getLogger("global");
    private String jdbcURL = "jdbc:mysql://localhost:3306/moviedb";
    private String username = "root";
    private String password = "";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    private static final String INSERT_MOVIE = "INSERT INTO movies" + "  (movieid, title, actress,actor,genre,year) VALUES "
            + " (?, ?, ?,?,?,?);";
    private static final String SELECT_ALL_MOVIES = "select * from movies";
    private static final String DELETE_MOVIE = "delete from movies where movieid=?";
    private static final String UPDATE_MOVIE = "update movies set title=?,actress=?,actor=?,genre=?,year=? where movieid=?;";
    private static final String SEARCH_BY_ID = "select * from movies where movieid=?;";
    private static final String SEARCH_BY_TITLE = "select * from movies where title=?;";
    private static final String SEARCH_BY_ACTRESS = "select * from movies where actress=?;";
    
    public DAO() {

    }

    protected Connection getConnection() {
        Connection conn = null;
        try {
            logger.info("Hello1");
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(jdbcURL, username, password);
        } catch (Exception e) {
            logger.info("Hello12");
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertMovie(Movies movie) {
        try {
            logger.info("Hello3");
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_MOVIE);
            ps.setInt(1, movie.getMovieid());
            ps.setString(2, movie.getTitle());
            ps.setString(3, movie.getActress());
            ps.setString(4, movie.getActor());
            ps.setString(5, movie.getGenre());
            ps.setInt(6, movie.getYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.info("Hello4");
            printSQLException(e);
        }
    }

    public List<Movies> selectAllMovies() {

        List<Movies> movies = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int movieid = rs.getInt("movieid");
                String title = rs.getString("title");
                String actress = rs.getString("actress");
                String actor = rs.getString("actor");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                movies.add(new Movies(movieid, title, actress, actor, genre, year));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return movies;
    }

    public List<Movies> search_by_id(int id) {
        List<Movies> movies = new ArrayList<>();
        try {
            Connection connection = getConnection();
        
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ID); {
            preparedStatement.setInt(1, id);
           
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int movieid = rs.getInt("movieid");
                String title = rs.getString("title");
                String actress = rs.getString("actress");
                String actor = rs.getString("actor");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                movies.add(new Movies(movieid, title, actress, actor, genre, year));
            }
        }
        } 
        catch (SQLException e) {
            printSQLException(e);
        }
        return movies;
    }
    
    public List<Movies> search_by_title(String name) {
        List<Movies> movies = new ArrayList<>();
        try {
            Connection connection = getConnection();
        
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_TITLE); {
            preparedStatement.setString(1, name);
           
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int movieid = rs.getInt("movieid");
                String title = rs.getString("title");
                String actress = rs.getString("actress");
                String actor = rs.getString("actor");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                movies.add(new Movies(movieid, title, actress, actor, genre, year));
            }
        }
        } 
        catch (SQLException e) {
            printSQLException(e);
        }
        return movies;
    }
    
    public List<Movies> search_by_actress(String name) {
        List<Movies> movies = new ArrayList<>();
        try {
            Connection connection = getConnection();
        
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ACTRESS); {
            preparedStatement.setString(1, name);
           
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int movieid = rs.getInt("movieid");
                String title = rs.getString("title");
                String actress = rs.getString("actress");
                String actor = rs.getString("actor");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                movies.add(new Movies(movieid, title, actress, actor, genre, year));
            }
        }
        } 
        catch (SQLException e) {
            printSQLException(e);
        }
        return movies;
    }
    
     public boolean updateMovie(Movies movie) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(UPDATE_MOVIE);) {
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getActress());
            statement.setString(3, movie.getActor());
            statement.setString(4, movie.getGenre());
            statement.setInt(5, movie.getYear());
            statement.setInt(6, movie.getMovieid());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
     
    public boolean deleteMovie(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); 
             PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
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
