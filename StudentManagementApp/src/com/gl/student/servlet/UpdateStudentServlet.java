package com.gl.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.student.pojo.Student;
import com.gl.student.service.StudentService;

@WebServlet("/edit")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service;
	public void init()
	{
		this.service=new StudentService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String parameter=request.getParameter("rollno");
		int rollno=Integer.parseInt(parameter);
		Student s=service.getStudent(rollno);
		
		out.println("<form method='post' action='http://localhost:90/StudentManagementApp/list'>");
		out.println("Student Rollno : &nbsp;&nbsp;<input type=text name='rollno' value='"+s.getRollno()+"' readonly><br><br>");
		out.println("Student Name : &nbsp;&nbsp;<input type=text name='name' value='"+s.getName()+"' readonly><br><br>");
		out.println("Student Address : &nbsp;&nbsp;<input type=text name='address' value='"+s.getAddress()+"'><br><br>");
		out.println("Student Rollno : &nbsp;&nbsp;<input type=text name='mobileno' value='"+s.getMobileNo()+"'><br><br>");
		out.println("<input type=submit value='Update'></form>");
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Student s=new Student();
		String rno=request.getParameter("rollno");
		int rollno=Integer.parseInt(rno);
		s.setRollno(rollno);
		s.setName(request.getParameter("name"));
		s.setAddress(request.getParameter("address"));
		s.setMobileNo(request.getParameter("mobileno"));
		
		boolean flag=service.updateStudent(s);
		// relative url
		RequestDispatcher rd=request.getRequestDispatcher("/list");
		if(flag)
		{
			out.println("<p style='color:green'>Updated...</p>");
			System.out.println("Student Updated Successfully.");
			rd.forward(request, response);
			// To print message to server console..
			
		}
		else
		{
			System.out.println("Student Not Updated .");
			out.println("<p style='color:red'>Student Details are not updated.. TRY AGAIN</p>");
			rd.include(request, response);
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
