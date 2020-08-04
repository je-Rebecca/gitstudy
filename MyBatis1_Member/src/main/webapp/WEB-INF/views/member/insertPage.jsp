<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signIn</title>
</head>
<body>
	<form action ="insert" method="post">
		id<input name ="mId" /><br>
		name<input name ="mName" /><br>
		<input type="submit" value ="가입"/>
		<input type="button" value ="list" onclick="location.href='listPage'"/>
		
	</form>
</body>
</html>