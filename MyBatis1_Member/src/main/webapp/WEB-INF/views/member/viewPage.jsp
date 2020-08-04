<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signIn</title>
<script type="text/javascript">
function fn_memberDelete(f){
	f.action ='delete';
	f.submit();
}
</script>
</head>
<body>
${mDTO.mNo } 번 회원 <br>
id: ${mDTO.mId } <br>
name: ${mDTO.mName } <br><br>

	<form action ="update" method="post">
		name<input name ="mName" value ="${mDTO.mName }" /><br>
		<input type="hidden" name="mNo" value="${mDTO.mNo }"/>
		<input type="submit" value ="수정"/>
		<input type="button" value ="삭제" onclick ="fn_memberDelete(this.form)"/>
		<input type="button" value ="list" onclick="location.href='listPage'"/>
	</form>
</body>
</html>