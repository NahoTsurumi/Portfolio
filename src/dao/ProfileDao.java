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
	
	/**
	 * DB接続コンストラクタ<br>
	 * インスタンス化時にDB接続が行われる
	 * @throws SQLException
	 */
	
	public ProfileDao() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dbportfo?serverTimezone=UTC";
		String user = "root";
		String pass = "949714";
		con = DriverManager.getConnection(url, user, pass);
	}
	
	/**
	 * DB接続を切るためのメソッド
	 */
	
	public void close() {
		try {
			if(con != null) con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ログイン時のデータ照合
	 * @param name 名前
	 * @param pass　パスワード
	 * @return ログイン成功時...1 <br>ログイン失敗時...0
	 * @throws SQLException
	 */
	
	public int getLoginInfo(String name, String pass) throws SQLException {
		int row = 0;
		sql = "SELECT * from user where name = ? and password = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2, pass);
		
		
		boolean zr = false;
		
		try {
			rs = ps.executeQuery();
			zr = rs.next();
			
			if(zr == true) {
				row += 1;
			}
		} finally {
			ps.close();
		}
		return row;
	}
	
	
	/**
	 * メソッド
	 */
	
	
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
