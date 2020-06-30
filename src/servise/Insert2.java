package servise;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao2;
import dbAccess.DBAccess3;

/**
 * DBAccessインターフェースを実装する登録クラス<br>
 * パラメータに受取った入力値をDBに登録する
 * @author user
 *
 */

public class Insert2 implements DBAccess3 {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		
		Dao2 dao2 = null;
		String input = request.getParameter("text");
		
		try {
			dao2 = new Dao2();
			if(dao2.insertData(input) > 0) {
				request.setAttribute("message", "投稿されました");
				System.out.println("投稿されています");
			} else {
				request.setAttribute("message", "投稿できませんでした");
				System.out.println("投稿できませんでした...");
			}
		} finally {
			if(dao2 != null) dao2.close();
		}
	}

	}
