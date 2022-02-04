<%-- Specify this is the error page --%>
<%@ page isErrorPage="true" %>
<html>
<body>
	<h3> An exception has occurred</h3>
	<table border=5>
		<tr>
		<td>Exception Class:</td>
		<%-- Obtain the name of exception class where 'exception' is the implicit object provided by JSP --%>
		<td><%= exception.getClass() %></td>
		</tr>
		<tr>
		<td>Message:</td>
		<%-- Obtain the exception message where 'exception' is the implicit object provided by JSP --%>
		<td><%= exception.getMessage() %></td>
		</tr>
	</table>
	<br>
	To go back to the login page click Login Page button
	<form name="f2" action="LoginPage.htm">
	<input type="submit" name="button1" value="Login Page">
	</form>

</body>
</html>
