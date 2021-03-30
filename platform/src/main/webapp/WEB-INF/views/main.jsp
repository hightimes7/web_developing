<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<div class="container text-center">
		<br><br><br><br><br><br>
			<h1>Hello World!</h1>
			<h1>로그인된 아이디 : ${member.id}</h1>
			<h1>로그인된 비밀번호 : ${member.pwd}</h1>
			<h1>로그인된 회원유형 : ${member.type}</h1>
		<br><br><br><br><br><br>
	</div>
</body>
</html>