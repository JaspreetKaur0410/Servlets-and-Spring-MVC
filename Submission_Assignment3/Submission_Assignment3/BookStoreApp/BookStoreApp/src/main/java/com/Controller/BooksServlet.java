/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import com.Bean.BooksBean;
import com.Dao.BooksDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jaspr
 */
public class BooksServlet extends HttpServlet {

    private BooksDao dao;
    private ArrayList<BooksBean> books;

    public void init() throws ServletException {
        dao = new BooksDao();
        books = new ArrayList<>();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getServletPath();

        switch (action) {
            case "/add":
                bookForm(request, response);
                break;
            case "/addbook":
                addBook(request, response);
                break;
            case "/list":
                listBooks(request, response);
                break;
            default:
                listBooks(request, response);
                break;
        }
    }

    private void bookForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.setAttribute("countbooks", Integer.parseInt(request.getParameter("countbooks")));
        RequestDispatcher rd = request.getRequestDispatcher("addbooks.jsp");
        rd.forward(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        PrintWriter out = response.getWriter();
        int count = Integer.parseInt(request.getParameter("countbooks"));

        String[] isbns = request.getParameterValues("isbn");
        String[] titles = request.getParameterValues("title");
        String[] authors = request.getParameterValues("author");
        String[] prices = request.getParameterValues("price");
      
        for(int i=0;i<count;i++){
           BooksBean book = new BooksBean(isbns[i], titles[i], authors[i],Double.parseDouble(prices[i]));
           dao.insertBook(book);
           List<BooksBean> listBooks = dao.selectAllBooks();
           request.setAttribute("listBooks", listBooks);
        }

        RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
        rd.forward(request, response);

    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
         List<BooksBean> listBooks = dao.selectAllBooks();
         request.setAttribute("listBooks", listBooks);
         RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
         rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BooksServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
