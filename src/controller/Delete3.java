package controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

import dao.Dao3;
import dbAccess.DBAccess4;

/**
 * DBAccessインターフェースを実装する削除クラス<br>
 * DBからパラメータに受取ったIDのデータを削除する
 * @author user
 *
 */

public class Delete3 implements DBAccess4 {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		Dao3 dao3 = null;
		int n = 0;
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		try {
			dao3 =new Dao3();
			n = dao3.delete(id);
			
			if (n > 0) {
				request.setAttribute("message", "投稿が削除されました");
				System.out.println("削除されています");
			} else {
				request.setAttribute("message", "投稿の削除に失敗しました");
				System.out.println("削除できませんでした...");
			}
		
		}finally {
			if(dao3 != null) dao3.close();
		}
	}

}
