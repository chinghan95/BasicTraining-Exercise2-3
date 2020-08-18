<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bookstore.javabeans.Bookstore"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore Application</title>
<style>
th, td, table {
	border: 1px, solid black;
}

td {
	text-align: center;
}

table.center {
	margin-left: auto;
	margin-right: auto;
}

/* .button { */
/* 	border: none; */
/* 	color: white; */
/* 	background-color: #555555; */
/* 	padding: 8px 16px; */
/* 	text-align: center; */
/* 	font-size: 16px; */
/* } */
</style>
</head>
<body>
	
	<h1>Bookstores Management</h1>
	
	<form>
		<input class="button" type="button" onclick="location.href='CreateForm.jsp'" value="Create New Bookstore!"/>
	</form>
	
	<table class="center" border="1" style="width:50%">
		<thead>
			<tr bgcolor="00CCFF">
				<th><b>Id</b></th>
				<th><b>Name</b></th>
				<th><b>Address</b></th>
				<th><b>Tel</b></th>
				<th><b>Actions</b></th>
			</tr>
		</thead>
		
		<%-- Fetching the attributes of the request object
				which was previously set by the servlet "ViewSerlet.java" --%>
		<tbody>
		<%
		// Iterating through subjectList
		// Null check for the object
		@SuppressWarnings("unchecked")
		List<Bookstore> listBookstore = (ArrayList<Bookstore>)request.getAttribute("bookstoresData");
		if(request.getAttribute("bookstoresData") != null)
		{
			for(Bookstore bookstore:listBookstore)
			{%>
				<%-- Arranging data in tabular form --%>
				<tr>
					<td><%=bookstore.getStoreId()%></td>
					<td><%=bookstore.getName()%></td>
					<td><%=bookstore.getAddress()%></td>
					<td><%=bookstore.getTel()%></td>
					<td>
						<a href='UpdateServlet?id=<%=bookstore.getStoreId()%>'><button type="button" class="update">Update</button></a>
						&nbsp; 
						<a href='DeleteServlet?id=<%=bookstore.getStoreId()%>'><button type="button" onclick="return confirm('Are you sure you want to delete this item?');" class="delete">Delete</button></a>
					</td>
				</tr>
			<%}
		}
		%>
		</tbody>
	</table>
	
</body>
</html>