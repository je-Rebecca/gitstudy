<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listPage</title>
<script type="text/javascript">
var beInserted = '${beInserted}'; 
if(beInserted == 'true'){
	var insertResult = '${insertResult}';
	if(insertResult == 1){
		alert('삽입성공')
	}else{
		alert('삽입실패')
	}
}

</script>
</head>
<body><div class="wrap">
	<table border ="1">
	<caption>total : ${totalCount } 개</caption>
	<thead>
		<tr><td>no.</td><td>작성자</td><td>제목</td><td>작성일</td></tr>
	</thead>
	<tbody>
	<c:if test ="${empty list }" ><tr><td colspan ="4">無</td></tr></c:if>
	<c:if test ="${not empty list }" >
		<c:forEach var="sDTO" items="${list }">
			<tr>
				<td>${sDTO.bNo }</td>
				<td>${sDTO.bWriter }</td>
				<td><a href="simpleViewPage?bNo=${sDTO.bNo}">${sDTO.bTitle }</a></td>
				<td>${sDTO.bDate }</td>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
	<tfoot>
	<tr>
		<td colspan ="4">
		<input type="button" value="new" onclick="location.href='simpleInsertPage'"/>
		</td>
	</tr>
	</table></div>
</body>
</html>