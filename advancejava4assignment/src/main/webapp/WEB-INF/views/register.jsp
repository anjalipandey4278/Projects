<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New User Registration</title>
	<%@include file="/WEB-INF/components/common_css_js_forall.jsp" %>
	<% %>
</head>
<body>
	<%@include file="/WEB-INF/components/navbar2.jsp" %>
	<div class="container-fluid">
		<div class="row mt-5"><!--row mt-5-->
		<div class="col-md-4 offset-md-4">
			<div class="card">
			<%@include file="/WEB-INF/components/message.jsp" %>
				<div class="card-body px-5">
					<h1 class="text-center my-4" >New User Registration</h1>
					<form action="userregister" method="post">
						<div class="mb-3">
					    	<label for="name" class="form-label">Name</label>
					    	<input name="user_name" type="text" class="form-control" id="name" placeholder="Enter your name" aria-describedby="emailHelp">
					    </div>
					    <div class="mb-3">
					    	<label for="email" class="form-label">E-Mail</label>
					    	<input name="user_email" type="email" class="form-control" id="email" placeholder="Enter your E-mail" aria-describedby="emailHelp">
					    </div>
					    <div class="mb-3">
					    	<label for="password" class="form-label">Set Password</label>
					    	<input name="user_password" type="password" class="form-control" id="password" placeholder="Enter here" aria-describedby="emailHelp">
					    </div>				    
					    <div class="container text-center">
					    	<button class="btn btn-outline-success">Register</button>
					    	
					    </div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>