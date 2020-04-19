package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import database.DBConnection;


public class StaffService {
	
	public String insertStaff(String nic, String name, String mobileno, String email, String gender, String specialize) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into staff (`staffID`,`staffNic`,`staffName`,`staffMobileno`,`staffEmail`,`staffGender`,`staffSpecialize`)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, nic);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, mobileno);
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, gender);
			preparedStmt.setString(7, specialize);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Staff member.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readStaff() {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>NIC</th><th>Staff Name</th><th>Mobile No</th><th>Email</th><th>Gender</th><th>Specialize</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from staff";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String staffID = Integer.toString(rs.getInt("staffID"));
				String staffNic = rs.getString("staffNic");
				String staffName = rs.getString("staffName");
				String staffMobileno = rs.getString("staffMobileno");
				String staffEmail = rs.getString("staffEmail");
				String staffGender = rs.getString("staffGender");
				String staffSpecialize = rs.getString("staffSpecialize");
				// Add into the html table
				output += "<tr><td>" + staffNic + "</td>";
				output += "<td>" + staffName + "</td>";
				output += "<td>" + staffMobileno + "</td>";
				output += "<td>" + staffEmail + "</td>";
				output += "<td>" + staffGender + "</td>";
				output += "<td>" + staffSpecialize + "</td>";
				
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\""
						+ " value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"staff.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"" + " class=\"btn btn-danger\">"
						+ "<input name=\"staffID\" type=\"hidden\" value=\"" + staffID + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the staff members.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateStaff(String ID, String nic, String name, String mobileno, String email, String gender, String specialize) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE staff SET staffNic=?,staffName=?,staffMobileno=?,staffEmail=?,staffGender=?,staffSpecialize=? " + "WHERE staffID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, nic);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, mobileno);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, gender);
			preparedStmt.setString(6, specialize);
			preparedStmt.setInt(7, Integer.parseInt(ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the staff member.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteStaff(String staffID) {
		String output = "";
		try {
			Connection con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from staff " + "where staffID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(staffID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the staff member.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}


