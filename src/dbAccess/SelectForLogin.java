package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.ProfileDao;

public class SelectForLogin implements DBAccess{

		@Override
		public void execute(HttpServletRequest request) throws SQLException {
			// TODO 自動生成されたメソッド・スタブ
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
		
	}
