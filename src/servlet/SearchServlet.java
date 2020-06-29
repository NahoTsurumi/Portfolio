package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbAccess.DBAccess2;
import dbAccess.SelectContent;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DBAccess2 dbAccess2;   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String selectWay = request.getParameter("selectWay");
		
		switch (selectWay) {
		case "content":
			dbAccess2 = new SelectContent();
			break;
		}
		try {
		dbAccess2.execute(request);
	}catch(SQLException e) {
		e.printStackTrace();
	}
	ServletContext context = getServletContext();
	RequestDispatcher dis = context.getRequestDispatcher("/board.jsp");
	dis.forward(request, response);
	}
}
