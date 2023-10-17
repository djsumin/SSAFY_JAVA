<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>게시글 수정</title>
<%@ include file="../common/bootstrap.jsp"%>
</head>
<body>
	<div class="container">
		<h2>글 수정</h2>
		<hr>
		<form action="update" method="POST">
		<input type="hidden" name="id" value="${board.id }">
			<div class="mb-3">
				<label for="title" class="form-label">글 제목</label> <input
					type="text" class="form-control" id="title" name="title" value="${board.title }">
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">글쓰니</label> <input
					type="text" class="form-control" id="writer" name="writer" value="${board.writer }" readonly>
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" rows="10" cols="30" id="content"
					name="content">${board.content }</textarea>
			</div>

			<button class="btn btn-primary">수정</button>

		</form>


	</div>
</body>
</html>
