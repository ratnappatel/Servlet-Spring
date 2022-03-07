package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ItemDatabase;
import model.Item;


/**
 * contact =>  name , email(pk), phone, password, city
 */
/**
 * Servlet implementation class ItemsServlet
 */
@WebServlet("/items")
public class ItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		response.setContentType("text/html");
		out.println("<html><head><style>table {border-spacing: 15px;border-bottom: "
				+ "1px scrollbar solid;border-collapse: collapse;}"
				+"th, td {border: 1px solid black;text-align: center;padding: 35px;}"
				+ "body{margin:30px;background-color: bisque;}</style></head><body>");
		
		out.println("<div class='container'><h1>Products Available</h1>");
		out.println("<table><tr><th>Item Id</th><th>Item Name</th><th>Manufacturer</th><th>Price</th>"
				+ "<th></th><th></th></tr>");
		ItemDatabase database = new ItemDatabase();
		try {
			for(Item item:database.getAllItems())
			{
				out.println("<tr><td>"+item.getItemid()+"</td>");
				out.println("<td>"+item.getItemname()+"</td>");
				out.println("<td>"+item.getManufacturer()+"</td>");
				out.println("<td>"+item.getPrice()+"</td>");
				out.println("<td><a href='edit?id="+item.getItemid()+"'>Edit</a></td>");
				out.println("<td><a href='delete?id="+item.getItemid()+"'>Delete</a></td></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</div></body></html>");
		
		
	}

}
