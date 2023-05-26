<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show note</title>
</head>
<body>
	<h1 class="text-center my-3">All Notes</h1>

	<c:forEach var="note" items="${notes }">
		<div class="border mb-3">
			<div class="text-center">
				<img style="width: 10%" src="assets/img/bg2.png" />
			</div>
			<div class="mx-5 mb-3">
				<h3>${note.title }</h3>
				<p>${note.content }</p>

				<p class="text-info mt-3 fw-semibold">Created by:
					${note.createdBy }</p>
				<p class="text-primary fw-semibold">
					Created date:
					<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
						value="${note.createdDate}" pattern="dd/MM/yyyy HH:mm:ss"/>
				</p>

				<div class="text-center">
					<a href="note?type=edit&id=${note.id}" class="btn btn-danger">Edit</a>
					<a href="note?type=delete&id=${note.id }" class="btn btn-primary">Delete</a>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>