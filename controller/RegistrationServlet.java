package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.*;
import connection.*;
import model.*;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");

        RequestDispatcher dispatcher = null;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = GetConnection.getConnection();
            System.out.println("Database connection established.");

            pst = con.prepareStatement("INSERT INTO `user` (uname, upwd, uemail) VALUES (?, ?, ?)");
            pst.setString(1, uname);
            pst.setString(2, upwd);
            pst.setString(3, uemail);


            System.out.println("Executing query...");
            int rowCount = pst.executeUpdate();
            System.out.println("Rows affected: " + rowCount);

            dispatcher = request.getRequestDispatcher("registration.jsp");
            if (rowCount > 0) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
            request.setAttribute("status", "SQL Error");
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);

        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
                System.out.println("Resources closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
