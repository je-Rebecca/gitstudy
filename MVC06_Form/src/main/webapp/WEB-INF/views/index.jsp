<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset=UTF-8">
<title>인덱스</title>
</head>
<body>
<form action ="member/login" method ="get">
	login 
	<label>id</label>
	<input name ="id" autofocus /> <br>
	<label>pw</label>
	<input type ="password" name ="pw"  /> <br>
	<input type ="submit" value ="로그인"  />
</form>	

<form action ="member/login2" method ="post">
	login 
	<label>id</label>
	<input name ="id" autofocus /> <br>
	<label>pw</label>
	<input type ="password" name ="pw"  /> <br>
	<input type ="submit" value ="로그인"  />
</form>	
 </body>
</html>