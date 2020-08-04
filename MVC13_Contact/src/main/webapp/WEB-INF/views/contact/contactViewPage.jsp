<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<script type="text/javascript">
	function fn_conatctDelete(f){
		if(confirm('삭제할까요?')){
			f.action ='contactDelete';
			f.submit(); 
		}
	}
	function fn_conatctUpdate(f){
		f.action ='contactUpdate';
		f.submit(); 
	}
</script>
</head>
<body>
 	<div><h3>${cDTO.cNo} 번 연락처</h3>
 	이름 : ${cDTO.cName}, 폰:${cDTO.cPhone}<br>
 	주소:${cDTO.cAddress} <br>이메일:${cDTO.cEmail}, 비고: ${cDTO.cNote},<br>
 	</div><br>
 	<form method="post">
 		<h3>정보 수정후 amend 클릭</h3>
 		<input name ="cName" value="${cDTO.cName}"/>
 		<input name ="cPhone" value="${cDTO.cPhone}"/><br>
 		<input name ="cAddress" value="${cDTO.cAddress}"/><br>
 		<input name ="cEmail" value="${cDTO.cEmail}"/>
 		<input name ="cNote" value="${cDTO.cNote}"/><br>
 		
 		<input type ="hidden" name ="cNo" value="${cDTO.cNo}"/>
 		<input type ="button" value ="삭제" onclick="fn_conatctDelete(this.form)"/>
 		<input type ="button" value ="amend" onclick="fn_conatctUpdate(this.form)"/>
 	</form>
</body>
</html>