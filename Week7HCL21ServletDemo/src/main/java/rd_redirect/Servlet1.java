package rd_redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><style>h1{color:red;}</style></head><body>");
		out.print("<h1>Welcome "+username+" in servlet 1</h1>");
		//out.print("<a href='s2?uname="+username+"'>Servlet2</h1>");
		//response.sendRedirect("s2?uname="+username);
		RequestDispatcher dispatcher = request.getRequestDispatcher("s2");
		dispatcher.forward(request, response);
		out.println("</body></html>");
	}

}











