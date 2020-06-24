package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao3;
import dbAccess.DBAccess4;

public class Insert3 implements DBAccess4 {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		Dao3 dao3 = null;
		String input = request.getParameter("text");
		
		try {
			dao3 = new Dao3();
			if(dao3.insertData(input) > 0) {
				request.setAttribute("message", "投稿されました");
				System.out.println("投稿されています");
			} else {
				request.setAttribute("message", "投稿できませんでした");
				System.out.println("投稿できませんでした...");
			}
		} finally {
			if(dao3 != null) dao3.close();
		}
	}

}
