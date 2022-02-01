package com.gl.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetServlet
 */
@WebServlet("/welcome")
public class GreetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
	{
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body><h1>");
		out.println("Welcome to the World of Web Programming Using Servlet Technology Session On ...<br>");
		Date d1=new Date();
		out.println(d1);
		out.println("</h1></body>");
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
	{
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<body><h1 style='color:red'>I am a POST Man for You.");
		out.println("</body></html>");
		
	}
	

}
