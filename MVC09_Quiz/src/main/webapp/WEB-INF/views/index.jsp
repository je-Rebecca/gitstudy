<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function(){
		$('#btn1').click(function(){
			$.ajax({
				url:'textHandler',  //RequestMapping 값
				type: 'GET',
				data: 'sender='+$('#sender').val(), 
				dataType: 'text',
				success: function(responseText){
					$('#content1').text(responseText); 
				},
				error: function(){
					alert('AJAX 통신 실패'); 
				}
			});
		});
		
	});
</script>
</head>
<body>
<h3>AJAX 통신 </h3>
<form>
	첫 번째 수 <input name="first"/> 
	두 번째 수 <input name="second"/> 
	<input type="button" name ="입력" onclick="location.href='view1.jsp'"/> 
	<div id="content1"></div>
</form>
</body>
</html>