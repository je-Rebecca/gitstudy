<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="v01" method ="get">
	<label>name</label><input name ="name" /><br>
	<label>dept</label><input name ="dept" /><br>
	<label>stuNo</label><input name ="stuNo" /><br>
	<input type="submit" value ="전송"/>
	</form>
	
	<form action ="v02" method ="post">
	<label>name</label><input name ="name" /><br>
	<label>dept</label><input name ="dept" /><br>
	<label>stuNo</label><input name ="stuNo" /><br>
	<input type="submit" value ="전송"/>
	</form>
</body>
</html>