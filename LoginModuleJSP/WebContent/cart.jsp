<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.*, com.gl.servlet.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! double totalCost=0.0; %>

<%
	ArrayList<Product> cart=(ArrayList<Product>)session.getAttribute("cart");
%>
<table border="3">
	<tr>
		<th>Product Id</th>
		<th>Product Title</th>
		<th>Product Price</th>
		<th>Product Quantity</th>
	</tr>
	<%
	for(Product p:cart)
	{ 
		totalCost+=p.getPrice();
%>
	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getTitle()%></td>
		<td><%=p.getPrice()%></td>
		<td><%=p.getQuantity()%></td>
	</tr>
	<%} %>
</table>
<h2>Total Order Value : <%=totalCost %></h2>
<a href=""><input type=button value="Place An Order"></a>
</body>
</html>