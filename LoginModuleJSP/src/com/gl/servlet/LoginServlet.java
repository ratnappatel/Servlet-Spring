package com.gl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gl.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service=new UserService();
	HttpSession session;
	PrintWriter out;
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		out=response.getWriter();
		String username=request.getParameter("user");
		String password=request.getParameter("pwd");
		boolean res=service.authenticate(username, password);
		if(res)
		{
			session=request.getSession(true);
			session.setAttribute("user", username);
			session.setAttribute("cart",new ArrayList<Product>());
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			out.println("<p style='color:red'>Invalid Credentials !!</p>");
			rd.include(request,response);
			
		}
	}
}
