<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save note</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty note}">
				<h1 class="text-center my-4">Edit Your Notes</h1>
			</c:when>
			<c:otherwise>
				<h1 class="text-center my-4">Add Your Notes</h1>
			</c:otherwise>
		</c:choose>

		<form action="note" method="POST">
			<c:choose>
				<c:when test="${not empty note}">
					<input type="hidden" name="type" value="edit">
					<input type="hidden" name="id" value="${note.id }">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="type" value="add">
				</c:otherwise>
			</c:choose>

			<div class="form-group mb-3">
				<label for="title">Title</label> <input type="text"
					class="form-control" value="${note.title}" id="title" name="title">
			</div>
			<div class="form-group mb-3">
				<label for="content">Content</label>
				<textarea class="form-control" rows="8" name="content" id="content">${note.content }</textarea>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary my-3">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>