<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コミュニティ</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
<h1>コスメが好きな人！</h1>
<div class="post">
<c:if test="${message != null}">
    <p class="message">${message}</p>
</c:if>

<form action="BoardServlet" method="post">
	<textarea name="text" rows="4" cols="100" placeholder="投稿してみよう！"></textarea>
	<input type="submit" name="button" value="POST">
</form>
</div>
<br>
<c:if test="${list != null}">
	<c:forEach var="i" items="${list}">
	
		<div class="pt"></div>
		<div class="name">${bean.name} - ${i.time}</div>
		<div class="content">${i.content}</div>
		
		<form action="BoardServlet" method="post" class="control">
		<input type="submit" name="button" value="">
		</form>
	</c:forEach>
</c:if>
</body>
</html>