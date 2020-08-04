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
		//Json가져오기
		$('#btn2').click(function(){
			$.ajax({
				url:'jsonHandler',  //RequestMapping 값
				type: 'GET',
				data: 'sender='+$('#sender').val(), 
				dataType: 'json',
				success:function(responseObj){
					$('#content2').text(responseObj.sender +","+responseObj['receiver']);
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
<from>
	보내는 사람 <input id ="sender" type="text" name ="sender" /> <br>
	<input id ="btn1" type ="button" value ="텍스트 가져오기" /><br>
	<div id="content1"></div>
	
	<input id ="btn2" type="button" value ="JSON가져오기" /><br>
	<div id="content2"></div>
</from>
</body>
</html>