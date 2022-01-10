
package com.Controller;

import com.bean.Movies;
import com.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 *
 * @author jaspr
 */
public class MoviesServlet extends HttpServlet {

    private DAO dao;

    public void init() throws ServletException {
        dao = new DAO();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                movieform(request, response);
                break;
            case "/insert":
                insertMovie(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            case "/search":
                searchmovie(request, response);
                break;
            case "/searching":
                searchingmovie(request, response);
                break;
            case "/update":
                updateMovie(request, response);
                break;
            case "/saveupdates":
                saveUpdates(request, response);
                break;
            case "/list":
                listMovies(request, response);
                break;
            default:
                listMovies(request, response);
                break;
        }
    }

    private void movieform(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PrintWriter out = response.getWriter();
        out.println("Hello");
        RequestDispatcher rd = request.getRequestDispatcher("movieform.jsp");
        rd.forward(request, response);
    }

    private void insertMovie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PrintWriter out = response.getWriter();
        //out.println("Hello2");
        String movieid = request.getParameter("movieid");
        String year = request.getParameter("year");
        String title = request.getParameter("title");
        String actress = request.getParameter("actress");
        String actor = request.getParameter("actor");
        String genre = request.getParameter("genre");
        out.println("<h1>" + movieid + "</h1>");
        Movies movie = new Movies(Integer.parseInt(movieid), title, actress, actor, genre, Integer.parseInt(year));
        dao.insertMovie(movie);

        List<Movies> listmovies = dao.selectAllMovies();
        request.setAttribute("listmovies", listmovies);
        RequestDispatcher rd = request.getRequestDispatcher("listmovies.jsp");
        rd.forward(request, response);
    }

    private void listMovies(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Movies> listmovies = dao.selectAllMovies();
        request.setAttribute("listmovies", listmovies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listmovies.jsp");
        dispatcher.forward(request, response);
    }

    private void searchmovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request, response);
    }

    private void searchingmovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String search = request.getParameter("searchbyid");

        if (request.getParameter("s_movie").equals("Search By ID")) {
            List<Movies> searchedmovies = dao.search_by_id(Integer.parseInt(search));
            request.setAttribute("searchedmovies", searchedmovies);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewsearchedmovie.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("s_movie").equals("Search By Title")) {
            List<Movies> searchedmovies = dao.search_by_title(search);
            request.setAttribute("searchedmovies", searchedmovies);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewsearchedmovie.jsp");
            dispatcher.forward(request, response);
        } else if (request.getParameter("s_movie").equals("Search By Actress")) {
            List<Movies> searchedmovies = dao.search_by_actress(search);
            request.setAttribute("searchedmovies", searchedmovies);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewsearchedmovie.jsp");
            dispatcher.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("<h1>" + "ERROR IN SEARCHING" + "</h1>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void updateMovie(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("movieid");
        List<Movies> searchedmovies = dao.search_by_id(Integer.parseInt(id));
        request.setAttribute("searchedmovies", searchedmovies.get(0));
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        dispatcher.forward(request, response);
    }
    private void saveUpdates(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        
        String movieid = request.getParameter("movieid");
        String year = request.getParameter("year");
        String title = request.getParameter("title");
        String actress = request.getParameter("actress");
        String actor = request.getParameter("actor");
        String genre = request.getParameter("genre");
        Movies movie = new Movies(Integer.parseInt(movieid), title, actress, actor, genre, Integer.parseInt(year));
        dao.updateMovie(movie);
        response.sendRedirect("list");
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String id = request.getParameter("movieid");
        dao.deleteMovie(Integer.parseInt(id));
        response.sendRedirect("list");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MoviesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MoviesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
