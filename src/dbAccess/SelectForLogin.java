package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.ProfileDao;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取ったID,パスワードを照合する<br>
 */

public class SelectForLogin implements DBAccess{

		@Override
		public void execute(HttpServletRequest request) throws SQLException {
			// TODO 自動生成されたメソッド・スタブ
			ProfileDao pBean = null;
			int n = 0;
			
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			
			//ユーザーネームとパスワードが文字列が空であるかどうかを判定
			if(name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
				request.setAttribute("message", "ユーザー名、パスワードを入力して下さい");
				request.setAttribute("flag", false);
				return;
			}
			
			
			//例外処理
			try {
				pBean = new ProfileDao();
				n = pBean.getLoginInfo(name,pass);
				
				//入力されたユーザーネームとパスワードが入力されたらデータを保存する
				if(n > 0) {
					request.setAttribute("flag", true);
					//入力されなかった場合
				} else {
					request.setAttribute("flag", false);
				}
				
				//例外が発生するしないに関わらず実行する文
			}finally {
				if(pBean != null)pBean.close();
			}
		}
		
	}
