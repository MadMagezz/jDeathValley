package controllers;


import model.User;
import model.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 1. Switching the button in doPost - sending in required method: richest or showById
 * 2. In method richest: do not getting any info from user. Just activating method in UserDAO.getTheRichestUser()
 * 3. In method showById: a) taking id from text field. b)Parsing. c)running method in UserDAO.getUserInformation(int id)
 * */
public class ControllerServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        /**
         * url, log, pass - context taking from web.xml в WEB-INF
         * */
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String button = request.getParameter("bt");
        try {
            if(button.equals("byId")){  //switching what button was pushed
                showById(request, response);
            } else if(button.equals("richest")){
                richest(request, response);
            }
        } catch(SQLException e){
            throw new ServletException(e);
        }
    }

    private void richest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        User resultUser = userDAO.getTheRichestUser(); //don't have to send anything. Just the richest.
        String nameResult = resultUser.getName();
        String sureNameResult = resultUser.getSureName();
        ArrayList<Integer> resultArray = resultUser.getAccountList();
        int accountSumResult = resultUser.getAccountSum();

        request.setAttribute("nameResult", nameResult);
        request.setAttribute("sureNameResult", sureNameResult);
        request.setAttribute("resultArray", resultArray);
        request.setAttribute("resultSum", accountSumResult);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showById(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        String addAnId = request.getParameter("add an Id");// getting id from jsp - "name" of textfield
        int id = Integer.parseInt(addAnId); //parsing id (better to add an exception)

        try {
            User resultUser = userDAO.getUserInformation(id); //создаём
            String nameResult = resultUser.getName();
            String sureNameResult = resultUser.getSureName();
            ArrayList<Integer> resultArray = resultUser.getAccountList();
            int accountSumResult = resultUser.getAccountSum();

            request.setAttribute("nameResult", nameResult);
            request.setAttribute("sureNameResult", sureNameResult);
            request.setAttribute("resultArray", resultArray);
            request.setAttribute("resultSum", accountSumResult);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
