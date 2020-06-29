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
import javax.servlet.http.HttpSession;

import dbAccess.DBAccess;
import dbAccess.SelectForLogin;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession(false);
	
	if(session != null) session.invalidate();
	
	
	response.setContentType("text/html; charset=UTF-8");
	ServletContext context = getServletContext();
	RequestDispatcher dis = context.getRequestDispatcher("/board.jsp");
	dis.forward(request, response);
	
}



protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	DBAccess dbAccess = new SelectForLogin();
	
	try {
		dbAccess.execute(request);
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	boolean flag = (boolean) request.getAttribute("flag");
	
	if (flag) {
		
		System.out.println("出力されています");
		response.sendRedirect("http://localhost:8080/Portfolio/ChatServlet");
		
	} else {
		System.out.println("エラー");
		doGet(request, response);
	}
		
	}
}