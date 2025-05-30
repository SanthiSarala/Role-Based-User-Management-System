package com.vcube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vcube.model.RegisterModel;

public class StudentDAO {

	// Insert User into Role-Specific Table
	public String insertStudent(RegisterModel student) {

		String query = " ";
		Connection con = com.vcube.utility.DBConnection.getConnection(); // Get connection

		if (con == null) {
			System.out.println("Database connection is NULL. Check DBConnection class.");
			return "DB_ERROR";
		}

		try {
			if ("admin".equalsIgnoreCase(student.getRole())) {
				query = "INSERT INTO admin(id,username, firstname, lastname, email, password) VALUES ( ?, ?, ?, ?, ?,?)";
			} else if ("teacher".equalsIgnoreCase(student.getRole())) {
				query = "INSERT INTO teacher(id,username, firstname, lastname, email, password) VALUES ( ?, ?, ?, ?, ?,?)";
			} else if ("student".equalsIgnoreCase(student.getRole())) {
				query = "INSERT INTO student(id,username, firstname, lastname, email, password) VALUES ( ?, ?, ?, ?, ?,?)";
			}

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,student.getId());
			ps.setString(2, student.getUsername());
			ps.setString(3, student.getFirstname());
			ps.setString(4, student.getLastname());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getPassword());
	

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				return "SUCCESS";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "FAILED";
	}

	// Validate User Login
	public RegisterModel validateUser(String username, String password, String role) {
	    String query = "";
	    RegisterModel user = null;

	    if ("admin".equalsIgnoreCase(role)) {
	        query = "SELECT id, username, firstname, lastname, email FROM admin WHERE username = ? AND password = ?";
	    } else if ("teacher".equalsIgnoreCase(role)) {
	        query = "SELECT id, username, firstname, lastname, email FROM teacher WHERE username = ? AND password = ?";
	    } else if ("student".equalsIgnoreCase(role)) {
	        query = "SELECT id, username, firstname, lastname, email FROM student WHERE username = ? AND password = ?";
	    } else {
	        System.out.println("❌ Invalid role provided: " + role);
	        return null;
	    }

	    try (Connection con = com.vcube.utility.DBConnection.getConnection()) {
	        if (con == null) {
	            System.out.println("❌ Database connection failed!");
	            return null;
	        }

	        try (PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, username);
	            ps.setString(2, password);

	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    user = new RegisterModel();
	                    user.setId(rs.getInt("id"));
	                    user.setUsername(rs.getString("username"));
	                    user.setFirstname(rs.getString("firstname"));
	                    user.setLastname(rs.getString("lastname"));
	                    user.setEmail(rs.getString("email"));
	                    user.setRole(role);

	                    System.out.println("✅ User found: " + user.getUsername());
	                    return user;
	                } else {
	                    System.out.println("❌ No user found for username: " + username + " and role: " + role);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}

}
