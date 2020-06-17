package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

public interface DBAccess {
	
	public void execute(HttpServlet request) throws SQLException;
	

}
