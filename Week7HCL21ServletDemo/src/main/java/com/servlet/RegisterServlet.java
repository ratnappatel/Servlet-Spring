package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CustomerDatabase;
import model.Customer;
import static utility.Constants.*;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter(NAME);
		String passwrod=request.getParameter(PASSWORD);
		String email=request.getParameter(EMAIL);
		String phone=request.getParameter(PHONE);
		String gst=request.getParameter(GST);
		String city=request.getParameter(CITY);
		String country=request.getParameter(COUNTRY);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if( (name != null && !name.trim().isEmpty())
				&& (country !=null && !country.trim().isEmpty() ) &&
				(!!email.isEmpty() || email != null) && (!phone.isEmpty() && phone != null) && 
				(!city.isEmpty() || city != null))
		{
			System.out.println("if not null");
		
			Customer c1 = new Customer(name,country, email,phone,passwrod, gst, city);
			System.out.println(c1);
			CustomerDatabase database = new CustomerDatabase();		
			try {
				if(database.insertCustomer(c1))
				{				
					System.out.println("insert true");
					response.sendRedirect("login.html");
				}
				else{
					System.out.println("insert false");
					RequestDispatcher rd = request.getRequestDispatcher("register.html");
					
					out.println("Please contact administrator");
					rd.include(request, response);
				}
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			out.println("Fill in all details");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");			
			rd.include(request, response);
			//response.sendRedirect("register.html");
		}
	}

}
