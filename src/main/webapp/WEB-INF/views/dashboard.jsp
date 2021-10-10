<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
	
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


<title>Item Search</title>
</head>
<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("/");
	}
	%>
	<%@ include file="navbar.jsp"%>
	<p id="addedDate"></p>
	<div class="container">
	
	<div class="d-flex justify-content-end mt-5">
    	<a href="addBook" class="btn btn-dark">Add Book <i class="fas fa-plus"></i></a>
  	</div>

	
	<table class="table text-center mt-4">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Book Code</th>
			<th scope="col">Book Name</th>
			<th scope="col">Author</th>
			<th scope="col">Date Added</th>
			<th scope="col">Action</th>
		</tr>
	</thead>
	<tbody>
	<% int count = 1; %>
	<c:forEach items="${books}" var="b">
		 <tr>
	      <td><%= count++ %></td>
	      <td>${b.bookCode}</td>
	      <td>${b.bookName}</td>
	      <td>${b.author}</td>
	      <td>${b.addedDate}</td>
	      <td><a class ="btn btn-info me-2" href="getbook/${b.id}"><i class="fas fa-edit"></i></a>
				<a class ="btn btn-danger ms-2" href="deletebook/${b.id}"><i class="fas fa-trash-alt"></i></a></td>
	     </tr>
    </c:forEach>
	</tbody>
	</table>
	
	</div>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
		
		<script src="js/app.js"></script>
	
</body>
</html>