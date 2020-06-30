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
import servise.HiddenWord;
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
		
		// 全データ抽出処理
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
			
			//DB挿入処理
				if (btn.equals("POST")) {
				String input = request.getParameter("text");
				
				//70文字以上ならdoGet
				if(input.length() >= 70 || input.equals("") || input == null) {
					request.setAttribute("message", "何も入力されていないか、70文字を超えています");
					
					doGet(request, response);
					return;
					
					//中傷ワードが投稿されそうになったら投稿させないようにする
				}else if (HiddenWord.isHiddenWord(input)) {
					System.out.println("in if");
					request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
					doGet(request, response);
					return;

					//中傷ワードが投稿されそうになったら投稿させないようにする
				}else if (HiddenWord.isHiddenWord2(input)) {
					System.out.println("in if2");
					request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
					doGet(request, response);
					return;
					
					//中傷ワードが投稿されそうになったら投稿させないようにする
				}else if (HiddenWord.isHiddenWord3(input)) {
					System.out.println("in if3");
					request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
					doGet(request, response);
					return;

					//中傷ワードが投稿されそうになったら投稿させないようにする
				}else if (HiddenWord.isHiddenWord4(input)) {
					System.out.println("in if4");
					request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
					doGet(request, response);
					return;

					//中傷ワードが投稿されそうになったら投稿させないようにする
				}else if (HiddenWord.isHiddenWord5(input)) {
					System.out.println("in if5");
					request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
					doGet(request, response);
					return;
					
					//中傷ワードが投稿されそうになったら投稿させないようにする
				}else if (HiddenWord.isHiddenWord6(input)) {
					System.out.println("in if6");
					request.setAttribute("message", "不適切な言葉が使われている可能性があります");
					
					doGet(request, response);
					return;
				}
				
				//文章を投稿させる処理
				dbAccess3 = new Insert2();
				
				//DB削除処理
			} else {
				dbAccess3 = new Delete2();
			}
			
			
			dbAccess3.execute(request);
				
				doGet(request, response);
				
				//例外処理
		} catch (Exception e) {
				System.out.println("Exception occured...");
				System.out.println(e);
			}

	}

}
