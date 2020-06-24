package servise;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dto.MessageDto;

public class Hidden {
	
	public void execute(HttpServletRequest request) throws SQLException {
	
	Dao dao = null;
	ArrayList<MessageDto> n = null;
	HiddenWord hidword = null;
	
	String content = request.getParameter("content");
	System.out.println(content);
	
	try {
		dao =new Dao();
		n = dao.getMessageFromcontent(content);
		
		if (n.equals(hidword)) {
			request.setAttribute("message", "不適切な言葉が含まれています");
			System.out.println("処理されました");
			
		} else {
			request.setAttribute("message", "失敗しました");
			System.out.println("処理されませんでした...");
		}
	
	}finally {
		if(dao != null) dao.close();
	}
}
}
