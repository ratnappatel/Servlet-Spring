<%-- Import the package --%>
<%@ page import ="java.util.*" %>
<%@ page import = "test.FindAuthor" %>
<html>
<head>
<title> JSP and JavaBean </title>
<font size=4 face="Verdana" color=#112244>
<%
request.getParameter("authorId");
%>

<%-- Create an instance of FindAuthor class --%>

<jsp:useBean id="FA" scope="application" class="test.FindAuthor" />
<%-- Set the value of various attribute, such as authorId, url, and driverName --%>

<jsp:setProperty name="FA" property="*" />

<body>

<%-- The details about the author, <jsp:getProperty name="FA" property="authorName"/> is:<BR> --%>
<%
	/* Create an instance of type of Vector and invoking the function getResult() to return the result set*/
	Vector v = (Vector)FA.getResult();
	Enumeration e1 = v.elements();
	/* Prints the elements in the vector variable */
	while(e1.hasMoreElements())
	{
		 out.println("Author First Name :"+e1.nextElement());
%>
<br>
<%
	 out.println("Author Last Name:"+e1.nextElement());
%>
<br>
<%
	 out.println("Author's Mobile No:"+e1.nextElement());}
%>
<br>

</body>
</head>
