package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connection.GetConnection;

public class Sales_pojo {
    private int sid;
    private String spname;
    private String target;
    private int nou;
    private int nous;

    public Sales_pojo() {
        // Default constructor
    }

    // Getters and Setters
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSpname() {
        return spname;
    }
    public void setSpname(String spname) {
        this.spname = spname;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    public int getNou() {
        return nou;
    }
    public void setNou(int nou) {
        this.nou = nou;
    }
    public int getNous() {
        return nous;
    }
    public void setNous(int nous) {
        this.nous = nous;
    }

    // Insert Sales
    public void insertSales() {
        String query = "INSERT INTO sales (sid, spname, target, nou, nous) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, sid);
            preparedStatement.setString(2, spname);
            preparedStatement.setString(3, target);
            preparedStatement.setInt(4, nou);
            preparedStatement.setInt(5, nous);
            preparedStatement.executeUpdate();
            System.out.println("Sales record inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting sales record: " + e.getMessage());
        }
    }

    // Update Sales
    public void updateSales() {
        String query = "UPDATE sales SET spname = ?, target = ?, nou = ?, nous = ? WHERE sid = ?";
        try (PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, spname);
            preparedStatement.setString(2, target);
            preparedStatement.setInt(3, nou);
            preparedStatement.setInt(4, nous);
            preparedStatement.setInt(5, sid);
            preparedStatement.executeUpdate();
            System.out.println("Sales record updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating sales record: " + e.getMessage());
        }
    }

    // Delete Sales
    public void deleteSales() {
        String query = "DELETE FROM sales WHERE sid = ?";
        try (PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, sid);
            preparedStatement.executeUpdate();
            System.out.println("Sales record deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting sales record: " + e.getMessage());
        }
    }

    // Fetch All Sales
    public List<Sales_pojo> showSales() {
        List<Sales_pojo> salesList = new ArrayList<>();
        String query = "SELECT * FROM sales";

        try (PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Sales_pojo sale = new Sales_pojo();
                sale.setSid(resultSet.getInt("sid"));
                sale.setSpname(resultSet.getString("spname"));
                sale.setTarget(resultSet.getString("target"));
                sale.setNou(resultSet.getInt("nou"));
                sale.setNous(resultSet.getInt("nous"));
                salesList.add(sale);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching sales records: " + e.getMessage());
        }

        return salesList;
    }
}
