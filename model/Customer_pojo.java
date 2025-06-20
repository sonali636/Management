package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.*;

public class Customer_pojo {
	int cid;
	String cname;
	String tlv;
	String aov;

	@Override
	public String toString() {
		return "Customer_pojo [cid=" + cid + ", cname=" + cname + ", tlv=" + tlv + ", aov=" + aov + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTlv() {
		return tlv;
	}

	public void setTlv(String tlv) {
		this.tlv = tlv;
	}

	public String getAov() {
		return aov;
	}

	public void setAov(String aov) {
		this.aov = aov;
	}

	public void insertCustomer() {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.GetConnection.getConnection()
					.prepareStatement("insert into customer values(?,?,?,?)");
			preparedStatement.setInt(1, cid);
			preparedStatement.setString(2, cname);
			preparedStatement.setString(3, tlv);
			preparedStatement.setString(4, aov);
			preparedStatement.executeUpdate();
			System.out.println("Inserted customer data succesfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateCustomer() {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.GetConnection.getConnection().prepareStatement("update customer set cname=?, tlv=?, aov=?  where cid=?");

			preparedStatement.setString(1, cname);
			preparedStatement.setString(2, tlv);
			preparedStatement.setString(3, aov);
			preparedStatement.setInt(4, cid);
            preparedStatement.executeUpdate();
			System.out.println("Updated customer data succesfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteCustomer() {

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.GetConnection.getConnection().prepareStatement("delete from customer where cid = ?");
			preparedStatement.setInt(1, cid);
			preparedStatement.executeUpdate();
			System.out.println("Deleted customer data successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showCustomer() {
		ResultSet resultSet;
		try {
			resultSet =connection.GetConnection.getConnection().prepareStatement("select * from customer").executeQuery();
			while (resultSet.next()) {
				System.out.println("Customer ID: " + resultSet.getInt(1));
	            System.out.println("Customer Name: " + resultSet.getString(2));
	            System.out.println("TLV: " + resultSet.getString(3));
	            System.out.println("AOV: " + resultSet.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}