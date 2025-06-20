

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static Connection getConnection() throws SQLException {
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish connection
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/g7?useSSL=false", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver not found");
        }
    }

}
