package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ProfileBean;

public class ProfileDao {

	private Connection con;
	private String sql;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ProfileDao() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dbportfo?serverTimezone=UTC";
		String user = "root";
		String pass = "949714";
		con = DriverManager.getConnection(url, user, pass);
	}
	
	public void close() {
		try {
			if(con != null) con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getLoginInfo(String name, String pass) throws SQLException {
		int row = 0;
		sql = "SELECT * from user where name = ? and password = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2, pass);
		
		try {
			rs = ps.executeQuery();
			rs.last();
			row = rs.getRow();
		} finally {
			ps.close();
		}
		return row;
	}
	
	public int insertAccount(ProfileBean pBean) throws SQLException {
		sql = "INSERT INTO user (name, password) VALUES (?, ?)";
		int n = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pBean.getName());
			ps.setString(2, pBean.getPass());
			
			n = ps.executeUpdate();
		} finally {
			ps.close();
		}
		return n;
	}
	
}
