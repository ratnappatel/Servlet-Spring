package com.gl.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleDemo
 */
@WebServlet("/demo")
public class LifeCycleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int users;
    public void init()throws ServletException
    {
    	System.out.println("Servlet Instance is Created ");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		users++;
		PrintWriter out=response.getWriter();
		out.println("Total No of Users accessing this webpage are : "+users);
		this.destroy();
		
	}
	public void destroy()
	{
		System.out.println("Destroying LifeCycleDemo Servlet.......");
	}

}
