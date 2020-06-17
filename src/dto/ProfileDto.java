	package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ProfileBean;

public class ProfileDto {
	
	private Connection con;
	private String sql;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int getLoginInfo(String name, String pass) throws SQLException {
		
		// TODO 自動生成されたメソッド・スタブ
		int row = 0;
		sql = "SELECT * from user where name = ? and password = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
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
	
	public int insertAccount(ProfileBean dto) throws SQLException {
		sql = "INSERT INTO user (name, password) VALUES (?, ?)";
		int n = 0;
		
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPass());
			
			
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		return n;
	}

}