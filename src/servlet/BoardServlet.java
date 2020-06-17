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
import servise.Insert;
import servise.Select;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBAccess2 dbAccess;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @param dbAccess 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, Select dbAccess) throws ServletException, IOException {
		
		dbAccess = new Select();
		
		try {
			dbAccess.execute(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/board.jsp");
		dis.forward(request, response);
	}

	/**
	 * @param dbAccess 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("button");
		System.out.println(btn);
		
		try {
			
			if (btn.equals("POST")) {
				String input =request.getParameter("text");
				
				if(input.length() >= 50 || input.equals("") || input == null) {
					request.setAttribute("message", "何も入力されていないか、100文字を超えています");
					doGet(request, response);
					return;
					
				}
				dbAccess = new Insert();
				
			}else {
				dbAccess.execute(request);
				
			}
			
			dbAccess.execute(request);
				
				doGet(request, response);
			} catch (Exception e) {
				System.out.println("Exception occured...");
				System.out.println(e);
			}
	}
		
	}
