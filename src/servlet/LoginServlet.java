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

import dbAccess.SelectForLogin;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession(false);
	
	if(session != null) session.invalidate();
	
	if(request.getAttribute("message") =="null") request.setAttribute("message", "名前とパスワードを入れて下さい");
	
	
	
	response.setContentType("text/html; charset=UTF-8");
	ServletContext context = getServletContext();
	RequestDispatcher dis = context.getRequestDispatcher("/Login.jsp");
	dis.forward(request, response);
	
}



protected void doPost(HttpServletRequest request, HttpServletResponse response, SelectForLogin dbAccess) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	dbAccess = new SelectForLogin();
	
	try {
		dbAccess.execute(request);
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	boolean flag = (boolean) request.getAttribute("flag");
	
	if (flag) {
		
		response.sendRedirect("localhost:8080/Portfolio/ChatServlet");
	} else {
		doGet(request, response);
	}
		
	}
}