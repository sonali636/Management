package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sales_pojo;

@WebServlet("/Sales_servlet")
public class Sales_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action parameter");
            return;
        }

        Sales_pojo pojo = populateSalesPojo(request);

        switch (action) {
		    case "insert":
		        pojo.insertSales();
		        break;
		    case "update":
		        pojo.updateSales();
		        break;
		    case "delete":
		        pojo.deleteSales();
		        break;
		}

		// Fetch the updated sales list after any operation
		List<Sales_pojo> salesList = pojo.showSales(); // Ensure showSales method is implemented in Sales_pojo
		request.setAttribute("salesList", salesList);

		// Forward the request to Sshow.jsp
		request.getRequestDispatcher("Sshow.jsp").forward(request, response);
    }

    private Sales_pojo populateSalesPojo(HttpServletRequest request) {
        Sales_pojo pojo = new Sales_pojo();
        try {
            if (request.getParameter("sid") != null) {
                pojo.setSid(Integer.parseInt(request.getParameter("sid")));
            }
            if (request.getParameter("spname") != null) {
                pojo.setSpname(request.getParameter("spname"));
            }
            if (request.getParameter("target") != null) {
                pojo.setTarget(request.getParameter("target"));
            }
            if (request.getParameter("nou") != null) {
                pojo.setNou(Integer.parseInt(request.getParameter("nou")));
            }
            if (request.getParameter("nous") != null) {
                pojo.setNous(Integer.parseInt(request.getParameter("nous")));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return pojo;
    }
}
