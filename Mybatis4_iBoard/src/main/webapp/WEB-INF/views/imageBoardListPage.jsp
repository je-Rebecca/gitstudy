<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/assets/styles/style.css">
</head>
<body>
	<a href="uploadPage">새글 작성하기</a><br>
	<table border ="1">
		<thead><tr>
				<td>No</td><td>Image</td><td>Writer</td>
				<td>Title</td><td>Content</td><td>Date</td>
		</tr></thead>
		<tbody>
			<tr>
				<c:if test="${empty list}"><td colspan ="6">Nothing</td></c:if>
				<c:if test="${not empty list}">
					<c:forEach var="iDTO" items ="${list}">
					<tr>
						<td>${iDTO.iNo }</td>
						<td><a href ="download?iFilename=${iDTO.iFilename }"><img alt ="${iDTO.iFilename}"
						 src="${pageContext.request.contextPath}/resources/storage/${iDTO.iFilename}"></a></td>
						<td>${iDTO.iWriter }</td><td>${iDTO.iTitle }</td>
						<td>${iDTO.iContent }</td><td>${iDTO.iRegdate }</td>
					</tr>
					</c:forEach>
				</c:if>
			</tr>
		</tbody>
	</table>
</body>
</html>