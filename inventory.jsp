<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory Form</title>
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

.form-container {
            
            background: linear-gradient(135deg, #ff5c94,#c7ffcc, #75f0d1,#ff5c94);
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            width: 100%;
            max-width: 700px;
        }

h1 {
    text-align: center;
    color: #000000;
    font-size: 2.2rem;
    margin-bottom: 20px;
}

.form-group {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    align-items: center;
    margin-bottom: 15px;
}

.form-group label {
    flex: 1;
    min-width: 200px;
    text-align: left;
    font-weight: bold;
    font-size: 1rem;
}

.form-group input[type="text"] {
    flex: 2;
    padding: 12px;
    border-radius: 8px;
    border: 1px solid #ccc;
    font-size: 1rem;
    transition: all 0.3s ease;
    width: 100%;
}

.form-group input[type="text"]:hover {
    border-color: #800080;
    box-shadow: 0 2px 8px rgba(128, 0, 128, 0.3);
}

.btn {
    padding: 15px 30px;
    border: none;
    border-radius: 30px;
    font-size: 1rem;
    cursor: pointer;
    transition: all 0.3s ease;
    text-transform: uppercase;
    font-weight: bold;
    flex: 1;
    min-width: 150px;
}

.btn:hover {
            transform: scale(1.1);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .insert-btn {
            background: linear-gradient(to right, #ff8080, #ff4d4d);
            color: #000000;
        }

        .insert-btn:hover {
            background: linear-gradient(to right, #ff0000, #ff0000);
        }

        .update-btn {
           background: linear-gradient(to right, #ff8080, #ff4d4d);
            color: #000000;
        }

        .update-btn:hover {
            background: linear-gradient(to right, #ff0000, #ff0000);
        }

        .delete-btn {
           background: linear-gradient(to right, #ff8080, #ff4d4d);
            color: #000000;
        }

        .delete-btn:hover {
            background: linear-gradient(to right, #ff0000, #ff0000);
        }

        .show-btn {
           background: linear-gradient(to right, #ff8080, #ff4d4d);
            color: #000000;
        }

        .show-btn:hover {
            background: linear-gradient(to right, #ff0000, #ff0000);
        }

.form-actions {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
    margin-top: 20px;
}

.error {
    color: red;
    font-size: 0.9rem;
    margin-top: 5px;
}

.success-message {
    color: #4caf50;
    font-size: 1.2rem;
    margin-top: 20px;
    text-align: center;
}

@media (max-width: 768px) {
    h1 {
        font-size: 1.8rem;
    }

    .form-container {
        width: 90%;
    }

    input[type="text"] {
        font-size: 0.9rem;
    }

    .btn {
        width: 100%;
        margin-top: 10px;
    }
}

    </style>
   
</head>
<body>
    
    <div class="form-container">
        <h1>Inventory Management</h1>
        <form id="inventoryform" method="post" action="InventoryServlet">
            <div class="form-group">
                <label for="InventoryID">Inventory ID</label>
                <input type="text" name="iid" id="iid">
                <div id="InventoryIDError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="Inventory Name">Inventory Name </label>
                <input type="text" name="iname" id="iname">
                <div id="InventoryNameError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="description">Quantity </label>
                <input type="text" name="q" id="q">
                <div id="QuantityError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="Quantity">Available Quantity </label>
                <input type="text" name="aq" id="aq">
                <div id="QuantityError" class="error"></div>
            </div>
            
            

            <div class="form-actions">
                <input type="submit" name="action" value="insert" class="btn insert-btn">
                <input type="submit" name="action" value="update" class="btn update-btn">
                <input type="submit" name="action" value="delete" class="btn delete-btn">
                <input type="submit" name="action" value="show" class="btn show-btn">
            </div>
        </form>
    </div>
</form>
 </div>
   
</body>
</html>
