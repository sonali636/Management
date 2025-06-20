package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product_pojo {
	private String productid;
    private String productname;
    private String description;
    private String category;
    private String price;
    private String stockLevel;

    
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", description=" + description
				+ ", category=" + category + ", price=" + price + ", stockLevel=" + stockLevel + "]";
	}
	/**
	 * @return the productId
	 */
	public String getProductid() {
		return productid;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}
	/**
	 * @return the productName
	 */
	public String getProductname() {
		return productname;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the stockLevel
	 */
	public String getStockLevel() {
		return stockLevel;
	}
	/**
	 * @param stockLevel the stockLevel to set
	 */
	public void setStockLevel(String stockLevel) {
		this.stockLevel = stockLevel;
	}
	public void addProduct() {
    String sql = "INSERT INTO product (productid, productname, description, category, price, stockLevel) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement preparedStatement = connection.GetConnection.getConnection().prepareStatement(sql)) {
        preparedStatement.setString(1, getProductid());
        preparedStatement.setString(2, getProductname());
        preparedStatement.setString(3, getDescription());
        preparedStatement.setString(4, getCategory());
        preparedStatement.setString(5, getPrice());
        preparedStatement.setString(6, getStockLevel());
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Failed to add product.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

		
	
	public void updateProduct() {
    String sql = "UPDATE product SET productname=?, description=?, category=?, price=?, stockLevel=? WHERE productid=?";
    try (PreparedStatement preparedStatement = connection.GetConnection.getConnection().prepareStatement(sql)) {
        preparedStatement.setString(1, getProductname());
        preparedStatement.setString(2, getDescription());
        preparedStatement.setString(3, getCategory());
        preparedStatement.setString(4, getPrice());
        preparedStatement.setString(5, getStockLevel());
        preparedStatement.setString(6, getProductid());
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("No product found with the given ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

	public void deleteProduct() {
    String sql = "DELETE FROM product WHERE Productid=?";
    try (PreparedStatement preparedStatement = connection.GetConnection.getConnection().prepareStatement(sql)) {
        preparedStatement.setString(1, getProductid());
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("No product found with the given ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

	public List<Product_pojo> showProduct() {
	    List<Product_pojo> productList = new ArrayList<>();
	    String sql = "SELECT * FROM product";
	    try (PreparedStatement preparedStatement = connection.GetConnection.getConnection().prepareStatement(sql);
	         ResultSet resultSet = preparedStatement.executeQuery()) {
	        while (resultSet.next()) {
	            Product_pojo product = new Product_pojo();
	            product.setProductid(resultSet.getString("productid"));
	            product.setProductname(resultSet.getString("productname"));
	            product.setDescription(resultSet.getString("description"));
	            product.setCategory(resultSet.getString("category"));
	            product.setPrice(resultSet.getString("price"));
	            product.setStockLevel(resultSet.getString("stockLevel"));
	            productList.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return productList;
	}
}