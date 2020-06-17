package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProfileBean;
import dao.ProfileDao;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context =getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/Regist.jsp");
		dis.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		ProfileBean pBean = new ProfileBean();
		
		pBean.setName(name);
		pBean.setPass(pass);
		
		try {
			ProfileDao dao = new ProfileDao();
			
			if(dao.insertAccount(pBean)>0) {
				ServletContext context = getServletContext();
				RequestDispatcher dis = context.getRequestDispatcher("/Login.jsp");
				dis.forward(request, response);
				
			} else {
				doGet(request, response);
			}
		}  catch (SQLException e) {
			request.setAttribute("message", "そのパスワードは使用されています");
			e.printStackTrace();
			doGet(request, response);
		}
		
			
			
	}
}
