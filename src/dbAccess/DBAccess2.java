package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface DBAccess2 {
	
	public void execute(HttpServletRequest request) throws SQLException;

}
