<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardInsert"  method ="post">
<table border ="1px">
		<tr>
			<td>작성자</td>
			<td><input type="text" name ="bWirter"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name ="bTitle"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="10" cols="50 " name ="bContent"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan ="2">
				<input type="submit" value ="등록"/>
				<input type="button" value ="목록" onclick ="location.href='list'"/>
			</td>
		</tr>
	</table>
</form>	
</body>
</html>