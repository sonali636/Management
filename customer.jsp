<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #ff5c94,#ade8d4, #f5adcc, #ff5c94);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        h2 {
            text-align: center;
            color: #000000;
            margin-bottom: 40px;
            font-size: 32px;
        }

        form {
            background: linear-gradient(135deg, #ff5c94,#c7ffcc, #75f0d1,#ff5c94);
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            width: 100%;
            max-width: 700px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 30px; 
        }

        input[type="text"] {
            width: 100%;
            max-width: 500px;
            padding: 18px;
            margin: 10px 0;
            border: 1px solid #ced4da;
            border-radius: 10px;
            font-size: 18px;
            transition: border-color 0.3s ease, background-color 0.3s ease;
        }

        input[type="text"]:hover {
            background-color: #f1f2f6;
        }

        input[type="text"]:focus {
            border-color: #005200;
            outline: none;
            background-color: #f1f2f6;
        }
     input[type="text"]::placeholder {
    color: black;
        }
        .form-buttons {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
            margin-top: 20px; 
        }

        button {
            padding: 18px 25px;
            border: none;
            border-radius: 10px;
            font-size: 18px;
            cursor: pointer;
            background: linear-gradient(to right, #ff8080, #ffcccc);
            color: #000000;
            transition: transform 0.3s ease, background 0.3s ease;
        }

        button:hover {
            background: #0056b3;
            transform: scale(1.1);
        }

        button:active {
            transform: scale(0.95);
        }

        button[type="reset"] {
            background:  linear-gradient(to right, #ff8080, #ff4d4d);
        }

        button[type="reset"]:hover {
            background: #cc3300;
        }
    </style>
</head>
<body>
    <form id="customerForm" action="CustomerServlet" method="post">
        <h2>Customer Management</h2>
        <div class="form-group">
            <input type="text" name="cid" placeholder="Enter customer ID">
            <input type="text" name="cname" placeholder="Enter customer Name">
            <input type="text" name="tlv" placeholder="Total lifetime value">
            <input type="text" name="aov" placeholder="Average order value">
            
        </div>
        <div class="form-buttons">
            <button type="submit" name="insert" value="insert">ADD</button>
            <button type="submit" name="update" value="update">EDIT</button>
            <button type="submit" name="delete" value="delete">DELETE</button>
            <button type="submit" name="show" value="show">SHOW</button>
            <button type="reset"  value="clear">CLEAR</button>
        </div>
    </form>
</body>
</html>
