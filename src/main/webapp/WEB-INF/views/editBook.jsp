<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Ecommerce Product Mgmt</title>
</head>
<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("/");
	}
	%>
<%@ include file="navbar.jsp"%>
	<div class="container">
	
	<h3 class="text-center mt-5"> Edit Book </h3>
		<div class="col-md-6 offset-md-3 mt-3">
			<form class="needs-validation" action="editbookdata" method="POST" novalidate>
				<input type="hidden" value="${book.id}" name="id"/>
			 <div class="row mb-3">
			    <label for="bookcode" class="col-sm-2 col-form-label">Book Code</label>
			    <div class="col-sm-10">
			      <input readonly type="number" class="form-control-plaintext" id="bookcode" name="bookCode" value="${book.bookCode}" required>
			    </div>
  			</div>
  			
  			<div class="row mb-3">
			    <label for="bookname" class="col-sm-2 col-form-label">Book Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="bookname" name="bookName" value="${book.bookName}" required>
			    </div>
  			</div>
  			
  			<div class="row mb-3">
			    <label for="author" class="col-sm-2 col-form-label">Author</label>
			    <div class="col-sm-10">
			     <select class="form-select" name="author" id="author" required>
				 	 <option selected value="${book.author}">${book.author}</option>
				     <c:forEach items="${authors}" var="a">
						 <option value="${a.name}">${a.name}</option>
					 </c:forEach>
				</select>
			    </div>
  			</div>
  			
  			<div class="row mb-3">
			    <label for="date" class="col-sm-2 col-form-label">Added On</label>
			    <div class="col-sm-10">
			      <input readonly type="text" class="form-control-plaintext" id="date" name="addedDate" value="${book.addedDate}" required>
			    </div>
  			</div>
  			
  			<div class="d-grid gap-2 d-md-block text-center">
			  <button type="submit" class="btn btn-primary">Update Book</button>
			  <a href="/dashboard" class="btn btn-danger">Cancel</a>
			</div>
			</form>
		</div>
	
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
		
		<script src="js/app.js"></script>
</body>
</html>