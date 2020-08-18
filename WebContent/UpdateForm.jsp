<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bookstore.javabeans.Bookstore"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Form</title>
</head>
<body>

	<h1>Update Bookstore Form</h1>
	
	<%
	Bookstore bookstoreById = (Bookstore)request.getAttribute("bookstoreById");
	%>

	<form name="updateBookstoreForm" method="post" action="UpdateServlet2">
		<input type="hidden" name="storeId" value="<%=bookstoreById.getStoreId()%>">
		
		<label for="storeName">Name:</label><br>
		<input type="text" name="storeName" value="<%=bookstoreById.getName()%>"><br>
		<label for="storeAddress">Address:</label><br>
		<input type="text" name="storeAddress" value="<%=bookstoreById.getAddress()%>"><br>
		<label for="storeTelephone">Tel:</label><br>
		<input type="text" name="storeTelephone" value="<%=bookstoreById.getTel()%>"><br><br>
		
		<input type="submit" value="Update & Save">
	</form>

</body>
</html>