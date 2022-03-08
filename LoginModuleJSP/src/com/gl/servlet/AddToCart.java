package com.gl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	out.println("In Shopping Cart View");
	
		int id=Integer.parseInt(request.getParameter("id"));
		out.println("Id : "+id);
		HttpSession session=request.getSession(false);
		out.println(session==null);
		ArrayList<Product> cart=(ArrayList<Product>) session.getAttribute("cart");
		
		//out.println("No Of Products in Cart <h3>"+cart.size()+"</h3>");
		if(!cart.isEmpty()) 
		{
			for(int i=0;i<cart.size();i++)
			{
				Product p=cart.get(i);
				if(p.getId()==id)
				{
					p.setQuantity(p.getQuantity()+1);
					cart.set(i, p);
					break;
				}
				else
				{
					switch(id)
					{
						case 1: 
							cart.add(new Product(1,"Title 1",123.45,1));
							break;
						case 2: 
							cart.add(new Product(2,"Title 2",234.56,1));
							break;
						case 3: 
							cart.add(new Product(3,"Title 3",345.67,1));
							break;
						default:
							System.out.println("Invalid Product");
							break;
					}
					out.println(id+" : Added to the cart");
				}
				out.println(id+" : Quantity increased.");
			}
		}
		else
		{
			switch(id)
			{
				case 1: 
					cart.add(new Product(1,"Title 1",123.45,1));
					break;
				case 2: 
					cart.add(new Product(2,"Title 2",234.56,1));
					break;
				case 3: 
					cart.add(new Product(3,"Title 3",345.67,1));
					break;
				default:
					System.out.println("Invalid Product");
					break;
			}
			out.println(id+" : Added to the cart");
		}
			session.setAttribute("cart", cart);
			out.println("Products : "+cart.size());
			//response.sendRedirect("dashboard.jsp");
		}
}
