<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link rel="stylesheet" type="text/css" href="Regist.css">
</head>
<body>
	<header>
		<h1>新規会員登録</h1>
		<p>${message}</p>
	</header>
		<form action="Regist" method="post">
		<div class="un">
	<p><label>UserName<br><input type="text" class="button" name="name" required="required" placeholder="ユーザーネームを入力"></label><p>
	</div>
	<div class="pw">
 	<p><label>Password<br>
 	<input type="password" class="button" required="required" name="pass" placeholder="パスワードを入力"></label></p>
 	</div>
 	<div class="ps">
 	<p><button class="button2" type="submit" name="button" value ="button">subscribe</button></p>
 	</div>
 	<div class="rtn">
 	<a href="ToppageServlet">←　Return</a>
 	</div>
</form>
</body>
</html>