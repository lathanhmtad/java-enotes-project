<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<h2 class="text-center text-dark mt-5">Login Form</h2>
			<div class="card my-3">
				<form method="POST" action="auth?action=login" class="card-body cardbody-color p-lg-5">
					<div class="text-center">
						<img
							src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png"
							class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
							width="200px" alt="profile">
					</div>

					<div class="mb-3">
						<input type="text" class="form-control" id="email" name="email"
							aria-describedby="emailHelp" placeholder="Email">
					</div>
					<div class="mb-3">
						<input type="password" class="form-control" id="password"
							placeholder="Password" name="password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary px-5 mb-5 w-100">Login</button>
					</div>
					<div id="emailHelp" class="form-text text-center mb-5 text-dark">
						Not Registered? <a href="auth?action=register" class="text-dark fw-bold"> Create
							an Account</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>