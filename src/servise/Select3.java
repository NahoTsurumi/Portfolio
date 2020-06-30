package servise;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.Dao3;
import dbAccess.DBAccess4;
import dto.MessageDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * 全てのデータをArrayListとして取得する
 * @author user
 *
 */

public class Select3 implements DBAccess4 {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
	
		Dao3 dao3 =null;
		try {
			dao3 = new Dao3();
			ArrayList<MessageDto> list = dao3.getListAll();
			
			if(list != null) {
				request.setAttribute("list", list);
			} else {
				request.setAttribute("message", "まだデータがありません");
			}
		} finally {
			if(dao3 != null) dao3.close();
		}
	}

}
