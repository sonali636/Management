<%@ page import="java.util.List" %>
<%@ page import="model.Customer_pojo" %>
<%
    List<Customer_pojo> customerList = (List<Customer_pojo>) request.getAttribute("customerList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Information</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background:linear-gradient(135deg, #ff8080,#d6f5d6, #b3ffd9, #ffcccc);
            color: #000000; 
            margin: 0;
            padding: 0;
        }
        
        h1 {
            color: #000000;
            text-shadow: 3px 3px 8px rgba(0, 0, 0, 0.7);
            font-size: 2.5rem;
            text-align: center;
            margin: 30px 0;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: rgba(34, 34, 51, 0.9);
            border-radius: 8px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.5);
        }

        th, td {
             background: linear-gradient(135deg, #ff8080, #d6f5d6, #b3ffd9, #ffcccc);
            color: #000000; 
            padding: 15px;
            text-align: left;
            font-size: 1.1rem;
        }

        th {
            background-color: #444466;
            color: #000000;
            text-transform: uppercase;
        }

        tr:nth-child(even) {
            background-color: #2A2A3C;
        }

        tr:nth-child(odd) {
            background-color: #33334A;
        }

        tr:hover {
            background-color: #666666;
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
        .welcome-button
        {
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

    <h1>Customer Information</h1>

    <center>
        <form>
            <table>
                <tr>
                    <th>Customer ID</th>
                    <th>Customer Name</th>
                    <th>Total Lifetime Value</th>
                    <th>Average Order Value</th>
                </tr>
                <% 
                    if (customerList != null) {
                        for (Customer_pojo customer : customerList) {
                %>
                <tr>
                    <td><%= customer.getCid() %></td>
                    <td><%= customer.getCname() %></td>
                    <td><%= customer.getTlv() %></td>
                    <td><%= customer.getAov() %></td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4" style="text-align: center;">No customer data found.</td>
                </tr>
                <% 
                    }
                %>
            </table>
            <a href="customer.jsp" class="back-button">Back</a>
        </form>
    </center>

    
    <a href="index.jsp" class="welcome-button">Dashboard page</a>

</body>
</html>