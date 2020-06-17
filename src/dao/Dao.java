package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import dto.MessageDto;

public class Dao {
	
	 private static final Collectors Collector = null;
	public static Object dao;
	private Connection con;
	 private String sql;
	private Comparator<? super MessageDto> comparator;
	 
	 public Dao() throws SQLException {
		 
		 String url ="jdbc:mysql://localhost:3306/dbportfo2?serverTimezone=UTC";
		 String user = "root";
		 String pass ="949714";
		 con = DriverManager.getConnection(url, user,pass);
		 System.out.println("Connection success!");
		 
	 }
	 
	 public void close() {
		 try {
			 if(con != null) con.close();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public ArrayList<MessageDto> getListAll() throws SQLException {
		 
		 sql = "select * from tweet";
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 ArrayList<MessageDto> list =null;
		 
		 try {
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 list = new ArrayList<>();
			 MessageDto dto;
			 while(rs.next()) {
				dto = new MessageDto();
				dto.setContent(rs.getString("content"));
				dto.setTime(rs.getTimestamp("time"));
				list.add(dto);
			 }
			 rs.close();
		 } finally {
			 ps.close();
		 }
		 
		 return (ArrayList<MessageDto>) list.stream().sorted(comparator).collect(Collector.toList());
		 
	 }
	 
	 public int insertData(String input) throws SQLException {
		 String sql = "INSERT INTO tweet (content) VALUES(?)";
		 return executeUpdate(sql, input);
	 }
	 
	 
	 private int executeUpdate(String sql, String param) throws SQLException {
		 PreparedStatement ps = null;
		 int n = 0;
		 
		 try {
			 ps = con.prepareStatement(sql);
			 
			 if(isNumber(param)) ps.setInt(1, Integer.parseInt(param));
			 else ps.setString(1, param);
			 
			 
			 n = ps.executeUpdate();
		 }finally {
			 ps.close();
		 }
		 return n;
	 }

	 private boolean isNumber(String num) {
		 try {
			 Integer.parseInt(num);
			 return true;
		 } catch (NumberFormatException e) {
			 return false;
		 }
	 }
	 
}