package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBConnection;
import database.LoginUserDatabase;
import model.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
//http://localhost:8080/Week7HCL21ServletDemo/login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {

		super();
		System.out.println("Login Servlet Constructor");
		// TODO Auto-generated constructor stub
	}
	//	
	//	@Override
	//	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//		// TODO Auto-generated method stub
	//		super.doPut(req, resp);
	//	}
	//	
	//	@Override
	//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//		// TODO Auto-generated method stub
	//		super.doDelete(req, resp);
	//	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init called");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy called");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login Servlet do get");
		//		PrintWriter out = response.getWriter();
		//		response.setContentType("text/html");
		//		out.println("<html><head><style>h1{color:red;}</style></head><body>");
		//		out.println("<h1>Do Get Called</h1>");
		//		out.println("</body></html>");
		response.sendRedirect("login.html");
	}

	/**
	 * cannot make a post request except from a form submission
	 * or via javascript ajax request
	 * all other request are by default get
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());

		System.out.println("Login Servlet do post");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><style>h1{color:red;}</style></head><body>");
		LoginUserDatabase loginUserDatabase = new LoginUserDatabase();
		LoginUser user = new LoginUser(email, pwd);
		if(loginUserDatabase.validate(user)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("login.html");
		}

		out.println("</body></html>");
	}

}
