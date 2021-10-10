<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


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


<title>Item Search</title>
</head>
<body>
	<%
	if (session.getAttribute("username") != null) {
		response.sendRedirect("/dashboard");
	}
	%>
	<div class="container">
		<form class="needs-validation" action="loginform" method="POST"
			novalidate>
			<h1 class="text-center my-5">User Login</h1>
			<div class="col-md-6 offset-md-3">
				<%
				if (request.getAttribute("errorMsg") != null) {
				%>
				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<%= request.getAttribute("errorMsg")%>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
				<%
				}
				%>
				<div class="mb-3">
					<label for="username" class="form-label">Username</label> <input
						type="text" class="form-control" id="username" name="username"
						required maxlength=50>
					<div class="invalid-feedback">Username is required.</div>
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">Password</label> <input
						type="password" class="form-control" name="password" id="password"
						required maxlength=50>
					<div class="invalid-feedback">Password is required.</div>
				</div>
				<div class="col-12">
					<button type="submit" class="btn btn-primary">Login</button>
				</div>
			</div>
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>

	
</body>
</html>