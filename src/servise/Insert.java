package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dbAccess.DBAccess2;

/**
 * DBAccessインターフェースを実装する登録クラス<br>
 * パラメータに受取った入力値をDBに登録する
 * @author user
 *
 */

public class Insert implements DBAccess2 {

	public void execute(HttpServletRequest request) throws SQLException {
		
		Dao dao = null;
		String input = request.getParameter("text");
	

		try {
			dao = new Dao();
			if(dao.insertData(input) > 0) {
				request.setAttribute("message", "投稿されました");
				System.out.println("投稿されています");
				
				
			} else {
				request.setAttribute("message", "投稿できませんでした");
				System.out.println("投稿できませんでした...");
			}
		} finally {
			if(dao != null) dao.close();
		}
	}

}