<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_emailAuthConfirm(f){
	var authkey = '${authkey}';
	if(authkey != f.authkey.value){
		alert('인증키 오류');
		return;
	}else{
		alert('인증성공');
		location.href ='imageBoardListPage';
	}
}
</script>
</head>
<body>
	<form> 
	인증코드 입력<input name="authkey"/>
	<input type="button" value="인증" onclick="fn_emailAuthConfirm(this.form)"/>
	</form>
</body>
</html>