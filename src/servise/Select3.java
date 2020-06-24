package servise;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.Dao2;
import dbAccess.DBAccess4;
import dto.MessageDto;

public class Select3 implements DBAccess4 {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
	
		Dao2 dao2 =null;
		try {
			dao2 = new Dao2();
			ArrayList<MessageDto> list = dao2.getListAll();
			
			if(list != null) {
				request.setAttribute("list", list);
			} else {
				request.setAttribute("message", "まだデータがありません");
			}
		} finally {
			if(dao2 != null) dao2.close();
		}
	}

}
