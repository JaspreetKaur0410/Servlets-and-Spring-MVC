/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import com.Bean.Item;
import com.Bean.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jaspr
 */
public class CartServlet extends HttpServlet {
     ArrayList<Product> items;
    public void init(){
        items = new ArrayList();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getServletPath();
        //out.println("<h1>" + action + "</h1>");
        switch (action) {
            case "/addtocart":
                addItem(request, response);
                break;
            case "/addtocart/remove":
                removeItem(request, response);
                break;
            default:
                removeItem(request, response);
                break;
        }

    }

    private void addItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String user = (String) session.getAttribute("username");
        String[] books = request.getParameterValues("book");
        String[] phones = request.getParameterValues("phone");
        String[] womens = request.getParameterValues("women");
        
        if (user != null) {

            String link = request.getParameter("link");
            request.setAttribute("link", link);

           
            if (books != null) {
                for (int i = 0; i < books.length; i++) {
                    Product product = new Product(books[i]);
                    items.add(product);
                }
            }
            if (phones != null) {
                for (int i = 0; i < phones.length; i++) {
                    Product product = new Product(phones[i]);
                    items.add(product);
                }
            }
            if (womens != null) {
                for (int i = 0; i < womens.length; i++) {
                    Product product = new Product(womens[i]);
                    items.add(product);
                }
            }
            session.setAttribute("bookslist", books);
            session.setAttribute("phonelist", phones);
            session.setAttribute("womenlist", womens);
            session.setAttribute("itemlist", items);
            RequestDispatcher rd = request.getRequestDispatcher("addtocart.jsp");
            rd.forward(request, response);
            }
        }
    
     private void removeItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String user = (String) session.getAttribute("username");
        
        if (user != null) {
            session.removeAttribute(request.getParameter("item"));
            items.remove(request.getParameter("item"));
            out.println("<h1>"+request.getParameter("item")+"</h1>");
            if (items != null) {
                for (int i = 0; i < items.size(); i++) {
                    
                    if((items.get(i).toString()).equals(request.getParameter("item"))){
                        out.println("<h4>" + "Hello" +"</h4>");
                        items.remove(i);
                }
            }
                for (int i = 0; i < items.size(); i++) {
                    out.println("<h4>" + items.get(i) +"</h4>");
                }
            session.setAttribute("items", items);
            response.sendRedirect("../list.jsp");
            }
        }
     }

        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

       
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
