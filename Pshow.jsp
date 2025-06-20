<%@ page import="java.util.List" %>
<%@ page import="model.Product_pojo" %>
<%
    List<Product_pojo> products = (List<Product_pojo>) request.getAttribute("products");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inventory Management - Products</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background:linear-gradient(135deg, #ff8080,#d6f5d6, #b3ffd9, #ffcccc);
            color: #000000;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #000000; 
            margin-top: 30px;
            font-size: 2.8rem;
            letter-spacing: 2px;
            text-shadow: 0 4px 10px rgba(0, 0, 0, 0.7); 
        }

        table {
            width: 90%;
            margin: 30px auto;
            border-collapse: collapse;
            border-radius: 12px;
            overflow: hidden;
            background: rgba(0, 0, 0, 0.8); 
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.7); 
        }

        th, td {
             background:linear-gradient(135deg, #ff8080,#d6f5d6, #b3ffd9, #ffcccc);
            color: #000000;
            padding: 15px;
            text-align: left;
            border: 1px solid #333; 
        }

        th {
            background-color: #2a5298; 
            color: #000000;
            text-transform: uppercase;
            font-size: 16px;
            letter-spacing: 1px;
        }

        tr:nth-child(even) {
            background-color: rgba(42, 82, 152, 0.6); 
        }

        tr:nth-child(odd) {
            background-color: rgba(30, 60, 114, 0.6); 
        }

        tr:hover {
            background-color: rgba(255, 203, 69, 0.6); 
            cursor: pointer;
            transition: all 0.3s ease-in-out;
        }

        td {
            font-size: 15px;
            color: #000000; 
        }

        td:first-child {
            font-weight: bold;
        }

        .no-data {
            font-style: italic;
            text-align: center;
            color: #ffcb45; 
        }

        .back-button {
           position: relative;
            float: right;
            margin-top: 20px;
            background: linear-gradient(to right, #ff8080, #ffcccc);
            color:#000000;
            border: none;
            transition: all 0.3s ease;
            border-radius: 30px;
            padding: 10px 20px;
            font-weight: bold;
        }

        .back-button:hover {
        background: linear-gradient(to right, #ffcccc, #990000);
            transform: scale(1.1);
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.3);
        }

        
        .welcome-button {
            display: inline-block;
            position: fixed;
            bottom: 20px;
            right: 20px;
            padding: 10px 20px;
            background: linear-gradient(45deg, #ff8080, #ffcccc);
            color: #000000;
            text-decoration: none;
            font-size: 1rem;
            font-weight: bold;
            border-radius: 30px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.4);
            transition: transform 0.3s, background-color 0.3s;
}

.welcome-button:hover {
   background: linear-gradient(45deg, #ffcccc, #990000); 
    box-shadow: 0 12px 20px rgba(255, 87, 34, 0.6), 0 0 10px rgba(255, 193, 7, 0.5); 
    transform: scale(1.1); 
    color: #000000; 
}
    </style>
</head>
<body>
    <h1>Product Information</h1>
    <table>
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Category</th>
                <th>Price</th>
                <th>Stock Level</th>
            </tr>
        </thead>
        <tbody>
            <% if (products != null) { 
                for (Product_pojo product : products) { %>
                    <tr>
                        <td><%= product.getProductid() %></td>
                        <td><%= product.getProductname() %></td>
                        <td><%= product.getDescription() %></td>
                        <td><%= product.getCategory() %></td>
                        <td><%= product.getPrice() %></td>
                        <td><%= product.getStockLevel() %></td>
                    </tr>
            <%  } } else { %>
                <tr>
                    <td colspan="6" class="no-data">No products available.</td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <a href="product.jsp" class="back-button">Back</a>
     <a href="index.jsp" class="welcome-button">Dashboard page</a>

    
</body>
</html>
