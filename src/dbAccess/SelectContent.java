package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dto.MessageDto;

public class SelectContent implements DBAccess2 {

	public void execute(HttpServletRequest request) throws SQLException {
		
		Dao dao = null;
		String content = request.getParameter("content");
		System.out.println(content);
		
		try {
			if(content != null && !content.isEmpty()) {
				dao = new Dao();
				ArrayList<MessageDto> list = dao.getMessageFromcontent(content);
				if(list.size() > 0) {
					request.setAttribute("list", list);
				}else {
					request.setAttribute("message", "該当する投稿がありません");
				}
			} else {
				request.setAttribute("message", "入力が不正です");
			}
			
		} finally {
			if (dao != null) dao.close();
		}
		
		
	}

}
