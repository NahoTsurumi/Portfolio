package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.Dao2;
import dbAccess.DBAccess3;

public class Delete2 implements DBAccess3 {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		Dao2 dao2 = null;
		int n = 0;
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		try {
			dao2 =new Dao2();
			n = dao2.delete(id);
			
			if (n > 0) {
				request.setAttribute("message", "投稿が削除されました");
				System.out.println("削除されています");
			} else {
				request.setAttribute("message", "投稿の削除に失敗しました");
				System.out.println("削除できませんでした...");
			}
		
		}finally {
			if(dao2 != null) dao2.close();
		}
	}

}
