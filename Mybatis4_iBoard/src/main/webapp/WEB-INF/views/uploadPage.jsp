<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta charset=UTF-8>
<title>uploadPage</title>
<script type="text/javascript">

	function fn_multiUpload(f){
		f.action ='multiUpload';
		f.submit();
	}
</script>
</head>
<body>
	<form method ="post" enctype="multipart/form-data">
		writer<input name ="iWriter"/><br>
		title<input name ="iTitle"/><br>
		<textarea name ="iContent" placeholder ="내용" rows="5" cols="50"></textarea><br>
		첨부파일# <input type ="file" name ="files" multiple ="multiple"/><br> 
		
		<input type ="button" value ="multiupload" onclick ="fn_multiUpload(this.form)"/> 
	</form>
</body>
</html>