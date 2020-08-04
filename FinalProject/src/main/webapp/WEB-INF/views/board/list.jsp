<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form></form>
	<table border ="1px">
		<tr>
			<td>순번</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		
		<c:if test ="${empty list }">
			<tr >
			<td colspan ="4">게시물이 없습니다 </td>
			</tr>
		</c:if>	
		<c:if test ="${not empty list }">
			<tr >
			<td>${bDTO.bIDX}</td>
			<td>${bDTO.bWriter}</td>
			<td><a href="list?bIdx=${bDTO.bIdx}">${bDTO.bTitle}</a></td>
			<td>${bDTO.bDate}</td>
			</tr>
		</c:if>	
		<tr >
			<td colspan ="4"><input type="button" value="새글작성" onclick ="location.href='writePage'"/> </td>
	</table>
</body>
</html>