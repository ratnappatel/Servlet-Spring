<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>Product Id</td>
		<td>Product Title</td>
		<td>Product Price</td>
		<td>Add To Cart</td>
	</tr>
	<tr>
		<td>1</td>
		<td>Title1</td>
		<td>123.46</td>
		<td><a href="http://localhost:9090/LoginModuleJSP/addToCart?id=1"><input type=button value="Add To Cart"></a>
	</tr>
	<tr>
		<td>2</td>
		<td>Title2</td>
		<td>234.56</td>
		<td><a href="http://localhost:9090/LoginModuleJSP/addToCart?id=2"><input type=button value="Add To Cart"></a>
	</tr>
	<tr>
		<td>3</td>
		<td>Title3</td>
		<td>345.67</td>
		<td><a href="http://localhost:9090/LoginModuleJSP/addToCart?id=3"><input type=button value="Add To Cart"></a>
	</tr>
</table>
<a href="http://localhost:9090/LoginModuleJSP/cart.jsp">Go To Cart</a>
</body>
</html>