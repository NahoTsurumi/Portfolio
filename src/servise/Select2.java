package servise;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import dao.Dao2;
import dbAccess.DBAccess3;
import dto.MessageDto;

public class Select2 implements DBAccess3 {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		
		
		
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
	
	


