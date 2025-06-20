package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Inventary_pojo;

@WebServlet("/InventoryServlet")
public class InventoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            request.setAttribute("error", "Action parameter is missing.");
            request.getRequestDispatcher("show.jsp").forward(request, response);
            return;
        }

        Inventary_pojo inventaryPojo = new Inventary_pojo();

        try {
            String iidParam = request.getParameter("iid");
            int iid = (iidParam != null && !iidParam.isEmpty()) ? Integer.parseInt(iidParam) : 0;

            String iname = request.getParameter("iname");
            String qParam = request.getParameter("q");
            int q = (qParam != null && !qParam.isEmpty()) ? Integer.parseInt(qParam) : 0;

            String aqParam = request.getParameter("aq");
            int aq = (aqParam != null && !aqParam.isEmpty()) ? Integer.parseInt(aqParam) : 0;

            inventaryPojo.setiid(iid);
            inventaryPojo.setiname(iname);
            inventaryPojo.setq(q);
            inventaryPojo.setAq(aq);

            switch (action) {
                case "insert":
                    inventaryPojo.insertInventory();
                    request.setAttribute("message", "Inventory inserted successfully.");
                    break;
                case "update":
                    inventaryPojo.updateInventory();
                    request.setAttribute("message", "Inventory updated successfully.");
                    break;
                case "delete":
                    inventaryPojo.deleteInventory();
                    request.setAttribute("message", "Inventory deleted successfully.");
                    break;
            }

            // Fetch the updated inventory list
            List<Inventary_pojo> inventoryList = inventaryPojo.showInventory();
            request.setAttribute("inventory", inventoryList);

            // Forward the request to show.jsp
            request.getRequestDispatcher("show.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input. Please enter valid numbers.");
            e.printStackTrace();
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while processing your request.");
            request.getRequestDispatcher("show.jsp").forward(request, response);
        }
    }
}
