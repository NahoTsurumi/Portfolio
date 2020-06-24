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

import controller.Delete2;
import dbAccess.DBAccess3;
import servise.Insert2;
import servise.Select2;

/**
 * Servlet implementation class BoardServlet2
 */
@WebServlet("/BoardServlet2")
public class BoardServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBAccess3 dbAccess3;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
            dbAccess3 = new Select2();
		
		try {
			dbAccess3.execute(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/board2.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String btn = request.getParameter("button");
		System.out.println(btn);
		
		
		try {
				if (btn.equals("POST")) {
				String input = request.getParameter("text");
				
				if(input.length() >= 70 || input.equals("") || input == null) {
					request.setAttribute("message", "何も入力されていないか、70文字を超えています");
					
					doGet(request, response);
					return;
				}
				dbAccess3 = new Insert2();
				
			} else {
				dbAccess3 = new Delete2();
			}
			
			
			dbAccess3.execute(request);
				
				doGet(request, response);
		} catch (Exception e) {
				System.out.println("Exception occured...");
				System.out.println(e);
			}

	}

}
