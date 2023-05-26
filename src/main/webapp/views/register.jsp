<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<h2 class="text-center text-dark mt-5">Register Form</h2>
			<div class="card my-3">
				<form method="post" action="auth?action=register"
					class="card-body cardbody-color p-lg-5">

					<c:if test="${not empty message }">
						<div class="alert alert-${alert}" role="alert">${message }</div>
					</c:if>

					<div class="text-center">
						<img
							src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png"
							class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
							width="200px" alt="profile">
					</div>

					<div class="mb-3">
						<input type="text" class="form-control" id="name"
							placeholder="Họ và tên" name="fullName" required="required">
					</div>
					<div class="mb-3">
						<input type="email" class="form-control" id="email"
							aria-describedby="emailHelp" placeholder="Email" name="email"
							required="required">
					</div>
					<div class="mb-3">
						<input type="password" class="form-control" id="password"
							placeholder="Password" name="password" required="required">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary px-5 mb-5 w-100">Register</button>
					</div>
					<div id="emailHelp" class="form-text text-center mb-5 text-dark">
						Already have an account? <a href="auth?action=login"
							class="text-dark fw-bold"> Login</a>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>