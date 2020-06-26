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

import controller.Delete;
import dbAccess.DBAccess2;
import servise.HiddenWord;
import servise.Insert;
import servise.Select;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DBAccess2 dbAccess2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @param dbAccess
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		dbAccess2 = new Select();
		

		try {
			dbAccess2.execute(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/board.jsp");
		dis.forward(request, response);
	}

	/**
	 * @param dbAccess
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String btn = request.getParameter("button");

		try {
	
					if (btn.equals("POST")) {
							String input = request.getParameter("text");
								// HiddenWord hidword = null;
							System.out.println(HiddenWord.isHiddenWord(input));

							if (input.length() >= 70 || input.equals("") || input == null) {
								request.setAttribute("message", "何も入力されていないか、70文字を超えています");

					
								doGet(request, response);
								return;
					
							}else if (HiddenWord.isHiddenWord(input)) {
								System.out.println("in if");
								request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
								doGet(request, response);
								return;

							}else if (HiddenWord.isHiddenWord2(input)) {
								System.out.println("in if2");
								request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
								doGet(request, response);
								return;

							}else if (HiddenWord.isHiddenWord3(input)) {
								System.out.println("in if3");
								request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
								doGet(request, response);
								return;

							}else if (HiddenWord.isHiddenWord4(input)) {
								System.out.println("in if4");
								request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
								doGet(request, response);
								return;

							}else if (HiddenWord.isHiddenWord5(input)) {
								System.out.println("in if5");
								request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
								doGet(request, response);
								return;
					
							}else if (HiddenWord.isHiddenWord6(input)) {
								System.out.println("in if6");
								request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
								doGet(request, response);
								return;
							}
				
							dbAccess2 = new Insert();

							} else {
								dbAccess2 = new Delete();
							}

							dbAccess2.execute(request);

								doGet(request, response);
							} catch (Exception e) {
								System.out.println("Exception occured...");
								System.out.println(e);
		
		}
		
	}

}
