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
import dao.Dao;
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
		System.out.println(btn);

		try {
			if (btn.equals("POST")) {
				String input = request.getParameter("text");
				String content = request.getParameter("content");
				HiddenWord hidword = null;

				if (input.length() >= 70 || input.equals("") || input == null) {
					request.setAttribute("message", "何も入力されていないか、70文字を超えています");
					
				if (content.equals(hidword)) {
					request.setAttribute("message", "この投稿には不適切な言葉が入っています");
					
				}
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
