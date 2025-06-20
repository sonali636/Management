<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Sales Management</title>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap CSS -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous"
    />
    <style>
        body {
           background:linear-gradient(135deg, #ff8080,#d6f5d6, #b3ffd9, #ffcccc);
            background-size: cover;
            color: white;
            font-family: 'Poppins', sans-serif;
        }

      h1 {
    margin-top: 20px;
    margin-bottom: 30px;
    font-size: 2.8rem;
    font-weight: 700;
    text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);
    color:#000000;
    
}


        .table-container {
            background:linear-gradient(135deg, #ff8080,#d6f5d6, #b3ffd9, #ffcccc);
            border-radius: 15px;
            padding: 25px;
            box-shadow: 0 4px 25px rgba(0, 0, 0, 0.3);
        }

        .table {
            margin: 0;
            border-radius: 10px;
            overflow: hidden;
        }

        .table thead th {
    background: linear-gradient(135deg, #ff8080, #d6f5d6, #b3ffd9, #ffcccc);
    color: #000000; 
    font-size: 1rem;
    font-weight: bold;
}
    td
    {
     background: linear-gradient(135deg, #ff8080, #d6f5d6, #b3ffd9, #ffcccc);
    color: #000000; 
    }

        .table tbody tr {
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .table tbody tr:hover {
            transform: scale(1.02);
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
            background-color: rgba(37, 117, 252, 0.2);
        }

        .btn-back {
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

        .btn-back:hover {
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

        footer {
            margin-top: 30px;
            text-align: center;
            font-size: 0.9rem;
            color: rgba(255, 255, 255, 0.8);
        }
    </style>
</head>
<body>
    <main class="container mt-5">
        <div class="text-center">
            <h1>Sales Information</h1>
        </div>
        <div class="table-container">
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">SID</th>
                            <th scope="col">SNAME</th>
                            <th scope="col">TARGET</th>
                            <th scope="col">UNITS</th>
                            <th scope="col">TOTAL UNIT</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Use JSTL to iterate over the salesList -->
                        <c:forEach var="sale" items="${salesList}">
                            <tr>
                                <td>${sale.sid}</td>
                                <td>${sale.spname}</td>
                                <td>${sale.target}</td>
                                <td>${sale.nou}</td>
                                <td>${sale.nous}</td>
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            <div class="d-flex justify-content-end mt-3">
        <a href="sales.jsp" class="btn btn-back">Back</a>
         <a href="index.jsp" class="welcome-button">Dashboard page</a>
        
    </div>
        
    </main>

    <!-- Bootstrap JavaScript -->
    <script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"
    ></script>
</body>
</html>