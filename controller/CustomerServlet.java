package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer_pojo> customerList = new ArrayList<>();

        try {
            String i = request.getParameter("insert");
            String u = request.getParameter("update");
            String d = request.getParameter("delete");
            String s = request.getParameter("show");

            if (i != null) {
                Customer_pojo pojo = new Customer_pojo();
                pojo.setCid(Integer.parseInt(request.getParameter("cid")));
                pojo.setCname(request.getParameter("cname"));
                pojo.setTlv(request.getParameter("tlv"));
                pojo.setAov(request.getParameter("aov"));
                pojo.insertCustomer();
            } else if (u != null) {
                Customer_pojo pojo = new Customer_pojo();
                pojo.setCid(Integer.parseInt(request.getParameter("cid")));
                pojo.setCname(request.getParameter("cname"));
                pojo.setTlv(request.getParameter("tlv"));
                pojo.setAov(request.getParameter("aov"));
                pojo.updateCustomer();
            } else if (d != null) {
                Customer_pojo pojo = new Customer_pojo();
                pojo.setCid(Integer.parseInt(request.getParameter("cid")));
                pojo.deleteCustomer();
            }

            // Fetch the updated customer list to display in Cshow.jsp
            ResultSet resultSet = connection.GetConnection.getConnection()
                    .prepareStatement("SELECT * FROM customer").executeQuery();
            while (resultSet.next()) {
                Customer_pojo pojo = new Customer_pojo();
                pojo.setCid(resultSet.getInt("cid"));
                pojo.setCname(resultSet.getString("cname"));
                pojo.setTlv(resultSet.getString("tlv"));
                pojo.setAov(resultSet.getString("aov"));
                customerList.add(pojo);
            }
            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("Cshow.jsp").forward(request, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }
}
