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


/**
 * ログイン時に呼び出されるサーブレット<br>
 * ・doGet...ログインページに遷移<br>
 * ・doPost...データ照合処理を呼び出し、成功時は管理ページにリダイレクト、失敗時はログインページに戻る
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	// セッションの取得(なければnullが返ってくる)
		HttpSession session = request.getSession(false);
		// セッションの破棄
		if(session != null) session.invalidate();
	
	
	response.setContentType("text/html; charset=UTF-8");
	ServletContext context = getServletContext();
	RequestDispatcher dis = context.getRequestDispatcher("/Login.jsp");
	dis.forward(request, response);
	
}



protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	//インスタンス作成
	DBAccess dbAccess = new SelectForLogin();
	
	//例外が発生しているかの処理
	try {
		dbAccess.execute(request);
		
		//例外処理
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	//SelectForLoginで保存したデータを真偽する
	boolean flag = (boolean) request.getAttribute("flag");
	
	//もしflag(データ)なら異なるURLにクライアントのあて先を変更する
	if (flag) {
		
		System.out.println("サイトへ移動できています");
		response.sendRedirect("http://localhost:8080/Portfolio/ChatServlet");
		
		// 不正な操作が行われた場合
	} else {
		System.out.println("エラー");
		doGet(request, response);
	}
		
	}
}