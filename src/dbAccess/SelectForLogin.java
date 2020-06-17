package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import dao.ProfileDao;

public class SelectForLogin implements DBAccess{

		public void execute(HttpServletRequest request) throws SQLException {
			
			ProfileDao pBean = null;
			int n = 0;
			
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			
			if(name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
				request.setAttribute("message", "ユーザー名、パスワードを入力して下さい");
				request.setAttribute("flag", false);
				return;
			}
			
			try {
				pBean = new ProfileDao();
				n = pBean.getLoginInfo(name,pass);
				
				if(n > 0) {
					request.setAttribute("flag", true);
				} else {
					request.setAttribute("flag", false);
				}
				
			}finally {
				if(pBean != null)pBean.close();
			}
		}

		@Override
		public void execute(HttpServlet request) throws SQLException {
			// TODO 自動生成されたメソッド・スタブ
			
		}
		
	}
