package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product_pojo;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the same logic as POST
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String stockLevel = request.getParameter("stockLevel");

        String action = request.getParameter("action");

        Product_pojo pojo = new Product_pojo();
        pojo.setProductid(productId);
        pojo.setProductname(productName);
        pojo.setDescription(description);
        pojo.setCategory(category);
        pojo.setPrice(price);
        pojo.setStockLevel(stockLevel);

        try {
            switch (action) {
                case "insert":
                    pojo.addProduct();
                    request.setAttribute("message", "Product inserted successfully.");
                    break;

                case "update":
                    pojo.updateProduct();
                    request.setAttribute("message", "Product updated successfully.");
                    break;

                case "delete":
                    pojo.deleteProduct();
                    request.setAttribute("message", "Product deleted successfully.");
                    break;

                case "show":
                    request.setAttribute("products", pojo.showProduct());
                    break;

                default:
                    request.setAttribute("error", "Invalid action.");
            }

            // Fetch updated product list for display
            request.setAttribute("products", pojo.showProduct());
            request.getRequestDispatcher("Pshow.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while processing the request.");
            request.getRequestDispatcher("Pshow.jsp").forward(request, response);
        }
    }
}