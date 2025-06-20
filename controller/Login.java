package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("username");
        String upwd = request.getParameter("password");
        Connection connection = null;
        HttpSession httpSession = request.getSession();
        RequestDispatcher dispatcher = null;

        try {
            // Get the connection using the DatabaseConnection class
            connection = GetConnection.getConnection();

            // Prepare SQL query to check user credentials
            String sql = "SELECT * FROM user WHERE uemail = ? AND upwd = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uemail);
            preparedStatement.setString(2, upwd);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a user is found with matching credentials
            if (resultSet.next()) {
                // Set user name in session
                httpSession.setAttribute("name", resultSet.getString("uname"));
                // Forward to the home page (index.jsp)
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                // Login failed, forward back to login page
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("status", "error");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("status", "error");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
