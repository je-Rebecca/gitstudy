<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_update(f){
	f.action ='simpleUpdate'; //@Request..("update")연결
	f.submit();  }// post방식
function fn_delete(f){
		if(confirm('삭제할까요?')){
			f.action='simpleDelete';
			f.submit();
		}
	}
</script>
</head>
<body>
<form method="post">
	<table border ="1px">
		<tr>
			<td>순번</td>
			<td>${bDTO.bIdx}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${bDTO.bWriter}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" value="${bDTO.bTitle}" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="bContent" value="${bDTO.bContent}" /></td>
		</tr>
		<tr>
			<td colspan ="2">
				<input type="button" value ="수정" onclick="fn_update(this.form)" />
				<input type="button" value ="목록" onclick ="location.href='list'"/>
				<input type="button" value ="삭제" onclick="fn_delete(this.form)"  />
			</td>
			
		</tr>
	</table>
</form>	
</body>
</html>