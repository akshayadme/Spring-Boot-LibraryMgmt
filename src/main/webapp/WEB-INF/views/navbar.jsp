<nav class="navbar navbar-expand-lg navbar-light bg-info px-5">
	<div class="container-fluid">
		<a class="navbar-brand" href="/dashboard">Library Management</a>
		<form action="logoutForm" method="POST">
			<div class="d-flex justify-content-end">
				<span class="navbar-text"> Hi, <%=session.getAttribute("username")%></span>&emsp;
				<button type="submit" class="btn btn-sm btn-light" type="submit">Logout <i class="fas fa-sign-out-alt"></i></button>
			</div>
		</form>

	</div>
</nav>