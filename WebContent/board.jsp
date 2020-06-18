<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コミュニティ</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
<header>
<h1>コスメが好きな人！</h1>
</header>
<div class="post">
<c:if test="${message != null}">
    <p class="message">${message}</p>
</c:if>

<form action="BoardServlet" method="post">
 <div class="textbox">
	<textarea class="textbox-post" name="text" rows="4" cols="50" placeholder="投稿してみよう！"></textarea>
	</div>
	<div class="buttonps">
	<input class="button-post" type="submit" name="button" value="POST">
	</div>
	
</form>
</div>
<br>
<c:if test="${list != null}">
	<c:forEach var="i" items="${list}">
	<div class="tweet">
		
		<div>
		<div class="pt"></div>
		<div class="name">${bean.name} - ${i.time}</div>
		<div class="content">${i.content}</div>

		</div>
	</div>
	</c:forEach>
	
	</c:if>
</body>
</html>