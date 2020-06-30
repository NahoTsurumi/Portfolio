package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao;
import dbAccess.DBAccess2;


/**
 * DBAccessインターフェースを実装する削除クラス<br>
 * DBからパラメータに受取ったIDのデータを削除する
 * @author user
 *
 */
public class Delete implements DBAccess2 {

	public void execute(HttpServletRequest request) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		
		Dao dao = null;
		int n = 0;
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		try {
			dao =new Dao();
			n = dao.delete(id);
			
			if (n > 0) {
				request.setAttribute("message", "投稿が削除されました");
				System.out.println("削除されています");
			} else {
				request.setAttribute("message", "投稿の削除に失敗しました");
				System.out.println("削除できませんでした...");
			}
		
		}finally {
			if(dao != null) dao.close();
		}
	}

}
