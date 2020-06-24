package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface DBAccess4  {
	public void execute(HttpServletRequest request) throws SQLException;
}
