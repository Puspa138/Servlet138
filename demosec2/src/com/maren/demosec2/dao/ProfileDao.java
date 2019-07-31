package com.maren.demosec2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maren.demosec2.model.Profile;

public class ProfileDao {

	public static Connection getConnection()throws ClassNotFoundException,SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
	}
	public int save(Profile profile) {
		Connection con = null;
		Statement st = null;
		int res = 0;
		try {
			con = getConnection();
			st = con.createStatement();
			res = st.executeUpdate("INSERT INTO test.test (userid, name, email, mobile) VALUES ('"+profile.getUserid()+"', '"+profile.getName()+"', '"+profile.getEmail()+"', "+profile.getMobile()+")"); 
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public List<Profile> fetchAll() {
		List<Profile> list=null;
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM test.test");
			if(rs != null)
				list = new ArrayList<>();
			while(rs.next()) {
				Profile pr = new Profile();
				pr.setUserid(rs.getString("userid"));
				pr.setName(rs.getString("name"));
				pr.setEmail(rs.getString("email"));
				pr.setMobile(rs.getLong("mobile"));
				list.add(pr);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM test.test");
			while(rs.next()) {
				String id = rs.getString("userid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long mobile = rs.getLong("mobile");
				System.out.println("Id : " +id + "\tName : "+ name+ "\tEmail : " +email + "\tMobile : " +mobile );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

	}

}
