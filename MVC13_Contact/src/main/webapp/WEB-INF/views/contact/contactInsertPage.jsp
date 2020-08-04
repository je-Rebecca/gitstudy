<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<form action="contactInsert" method ="post">
	<table>
	<tbody>
		<tr>
			<td>이름</td><td><input name="cName"/></td>
		</tr>
		<tr>
			<td>전화</td><td><input name="cPhone"/></td>
		</tr>
		<tr>
			<td>주소</td><td><input name="cAddress"/></td>
		</tr>
		<tr>
			<td>메일</td><td><input name="cEmail"/></td>
		</tr>
		<tr>
			<td>비고</td><td><input name="cNote"/></td>
		</tr>
	</tbody>
	<tfoot><tr>
	<td colspan="2">
		<input type="submit" value="제출"/>
		<input type="reset" value="재작성"/>
		<input type="button" value="리스트"
		 onclick="location.href='contactListPage'"/>
	</td></tr>
	</table>
</form>
</body>
</html>