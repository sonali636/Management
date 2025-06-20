<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Inventary_pojo" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory Data</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
             background:linear-gradient(135deg, #ff8080,#d6f5d6, #b3ffd9, #ffcccc);
            color: #000000; 
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            color: #ff9800; 
            margin-top: 20px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.5);
            background-color: #1f1f1f; 
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
        background: linear-gradient(135deg, #ff8080, #d6f5d6, #b3ffd9, #ffcccc);
    color: #000000; 
            padding: 15px;
            text-align: center;
            border: 1px solid #333; 
        }

       
tr {
    background-color: white;
    color:#000000;
}
tr:nth-child(even) {
    background-color: white; 
    color:#000000;
}


tr:nth-child(odd) {
    background-color: white; 
    color:#000000;
}


tr:hover {
    background-color: white;
    transform: scale(1.02);
    transition: all 0.3s ease-in-out;
}

        td {
            font-size: 14px;
            color:#000000;;
        }

        td:first-child {
            font-weight: bold;
        }

        .no-data {
            font-style: italic;
            color: #757575;
        }

       
        table {
            border: 2px solid #ff9800;
            box-shadow: 0 0 15px #ff9800;
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

        .back-container {
            text-align: right;
            width: 80%;
            margin: 0 auto;
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
    <h2>Inventory Data</h2>
    <table>
        <thead>
            <tr>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Available Quantity</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<model.Inventary_pojo> inventory = (List<model.Inventary_pojo>) request.getAttribute("inventory");

                if (inventory != null && !inventory.isEmpty()) {
                    for (model.Inventary_pojo item : inventory) {
            %>
                        <tr>
                            <td><%= item.getiid() %></td>
                            <td><%= item.getiname() %></td>
                            <td><%= item.getq() %></td>
                            <td><%= item.getAq() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4" class="no-data">No Data Available</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <div class="back-container">
        <a href="inventory.jsp" class="back-button">Back</a>
         <a href="index.jsp" class="welcome-button">Dashboard page</a>
        
    </div>
</body>
</html>
