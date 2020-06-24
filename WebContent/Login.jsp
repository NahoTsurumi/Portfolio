<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="Regist.css">
</head>
<body>

<header>
<h1>LOGIN</h1>
<h2>今すぐコミュニティに参加してみましょう</h2>
<p>${message}</p>
</header>
<form action="LoginServlet" method="post">
		<div class="un">
	<p><label>UserName<br><input type="text" name="name" required="required" placeholder="ユーザーネーム"></label><p>
	</div>
	<div class="pw">
 	<p><label>Password<br>
 	<input type="password" required="required" name="pass"  placeholder="パスワード"></label></p>
 	</div>
 	<div class="ps">
 	<p><button type="submit" name="button" value="login">LOGIN</button></p>
 	</div>
 	<div class="rtn">
 	<a href="ToppageServlet">←　Return</a>
 	</div>
</form>
</body>
</html>