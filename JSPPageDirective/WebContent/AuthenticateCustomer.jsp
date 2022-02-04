<%-- Specify the name of the error page --%>
<%@ page errorPage="LoginErrorPage.jsp" %>
<html>
<body>
<font face ="verdana">
<%
	/* Retrieving the value of the uname text field */
	String user=request.getParameter("uname");
	/* Converting the string value into the integer value */
	int customerID=Integer.parseInt(user); // NumberFormateException 
	/* Retrieving the value of the password text field */
	String pass=request.getParameter("password");
	/* Validate the customerID and password */
	if( customerID== 1010 && pass.equals("Jackson"))
	{	
		out.println("Welcome to Online Banking System");
%>
<br>
<br>
<%			
		out.println("Login Successful");
	}
	else
	{
		out.println("Login Unsuccessful");	
	}
%>
</font>
</body>
</html>
