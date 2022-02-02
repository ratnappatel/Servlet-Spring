package com.gl.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.student.service.StudentService;

/**
 * Servlet implementation class StudentListServlet
 * First Page of Application will always been accessed via get 
 * request/because browsers default http-request method is get
 */
@WebServlet("/list")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service;
	
	public void init()
	{
		service=new StudentService();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<head><title>Student Management Application</title></head>");
		out.println("<input type=submit value='Add New Student'><br>");
		out.println("<table border='5'><tr><th>Roll No</th><th>Student Name</th><th>Student Address</th><th>Mobile No</th><th>Actions</th</tr>");
		
		try 
		{
			ResultSet res=service.getAllStudents();
			while(res.next()) 
			{
				int rollno=res.getInt("rollno");
				out.println("<tr>");
				out.println("<td>"+rollno+"</td>");
				out.println("<td>"+res.getString("name")+"</td>");
				out.println("<td>"+res.getString("address")+"</td>");
				out.println("<td>"+res.getString("mobileno")+"</td>");
				out.println("<td><a href='http://localhost:90/StudentManagementApp/edit?rollno="
				+rollno+"'>Edit</a>");
				out.println("<a href='http://localhost:90/StudentManagementApp/delete?rollno="
				+rollno+"'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {e.printStackTrace();}	
		
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
