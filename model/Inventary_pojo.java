package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.GetConnection;

public class Inventary_pojo {
	
		int iid;
		String iname;
		int q;
		int aq;
		
		@Override
		public String toString() {
			return "Inventary_pojo [iid=" + iid + ", iname=" + iname + ", q=" + q + ", aq=" + aq + "]";
		}
		public int getiid() {
			return iid;
		}
		public void setiid(int iid) {
			this.iid = iid;
		}
		public String getiname() {
			return iname;
		}
		public void setiname(String iname) {
			this.iname = iname;
		}
		public int getq() {
			return q;
		}
		public void setq(int q) {
			this.q = q;
		}
		public int getAq() {
			return aq;
		}
		public void setAq(int aq) {
			this.aq = aq;
		}
		public void insertInventory() {
			PreparedStatement preparedStatement;
			try {
				preparedStatement = GetConnection.getConnection().prepareStatement("insert into inventory values (?,?,?,?)");
				preparedStatement.setInt(1,iid);
				preparedStatement.setString(2,iname);
				preparedStatement.setInt(3,q);
				preparedStatement.setInt(4,aq);
				try {
				    preparedStatement.executeUpdate();
				    System.out.println("Inserted data successfully...");
				} catch (SQLException e) {
				    e.printStackTrace();  // Print exception details
				    System.out.println("Error while inserting data");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		public void updateInventory() {
			PreparedStatement preparedStatement;
			try {
				preparedStatement = GetConnection.getConnection()
						.prepareStatement("UPDATE inventory SET iname = ?, q = ?, aq = ? WHERE iid = ?"
	);
				
				preparedStatement.setString(1, iname);
				preparedStatement.setInt(2, q);
				preparedStatement.setInt(3, aq);
				preparedStatement.setInt(4, iid);
				preparedStatement.executeUpdate();
				System.out.println("Updated data succesfully...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		public void deleteInventory() {

			PreparedStatement preparedStatement;
			try {
				preparedStatement = GetConnection.getConnection().prepareStatement("DELETE FROM inventory WHERE iid = ?");

				preparedStatement.setInt(1, iid);
				preparedStatement.executeUpdate();
				System.out.println("Deleted data successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		public List<Inventary_pojo> showInventory() {
		    List<Inventary_pojo> inventoryList = new ArrayList<>();
		    try (Connection con = GetConnection.getConnection();
		         PreparedStatement pst = con.prepareStatement("SELECT * FROM inventory")) {

		        ResultSet rs = pst.executeQuery();
		        while (rs.next()) {
		            Inventary_pojo item = new Inventary_pojo();
		            item.setiid(rs.getInt("iid"));
		            item.setiname(rs.getString("iname"));
		            item.setq(rs.getInt("q"));
		            item.setAq(rs.getInt("aq"));
		            inventoryList.add(item);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return inventoryList;
		}

		
}
