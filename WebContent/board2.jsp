<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>コミュニティ</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
<header>
<h1>猫愛好家</h1>
</header>
<div class="logout">
<a class="lgout" href="http://localhost:8080/Portfolio/LoginServlet">ログアウト</a>
</div>
<div class="post">
<c:if test="${message != null}">
    <p class="message">${message}</p>
</c:if>

<form action="BoardServlet2" method="post">
 <div class="textbox">
	<textarea class="textbox-post" name="text" rows="4" cols="50" placeholder="投稿してみよう！"></textarea>
	</div>
	<div class="buttonps">
	<input class="button-post" title="投稿" type="submit" name="button" value="POST">
	</div>
	
</form>
</div>
<br>
<c:if test="${list != null}">
	<c:forEach var="i" items="${list}">
	<div class="tweet">
		
		<div>
		<div class="pt"></div>
		<div class="id">${i.id}</div>
		<div class="name">${bean.name} - ${i.time}</div>
		<div class="content">${i.content}</div>
		<form action="BoardServlet2" method="post" class="control">
						<input title="削除" type="submit" name="button" class="delete" value="">
						<input type="hidden" name="id" value="${i.id}">
					</form>

		</div>
	</div>
	</c:forEach>
	
	</c:if>

</body>
</html>