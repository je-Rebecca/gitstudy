<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	 $(function(){
		 $('#btn').click( fn_send);
		 function fn_send(){
			var name = $('#name').val();
			var age = $('#age').val(); 
			var obj = {"name": name, "age":age};
			$.ajax({
				url:'person',
				type:'post',
				data: JSON.stringify(obj), //서버로 보내는 데이터 
				contentType:'application/json',  //@requestbody에서 필요한 부분 
				dataType:'json',  //서버에서 받는 데이터 타입
				success:  function(response){ //정상적으로 변환되었다면, 
					$('#content').empty();
					$('#content').append('<ul>');
					$('#content').append('<li>이름 :' + response.name +'</li>');
					$('#content').append('<li>나이 :' + response.age +'</li>');
					$('#content').append('</ul>');
				},
				error: function(){
					alert('오류 발생');
				}
			});
		}
		 
		 
		$('#btnList').on('click',fn_getList);  
		
		 function fn_getList(){
			 $.ajax({
				 url:'getListJSON',
				 dataType:'json', 
				 success: function(response){
					 var array = response;
					 $('#list').empty(); 
					 $.each(array, function(i, personDTO){
						$('#list').append('<tr>'); 
						$('#list').append('<td>'+ (i + 1) + '</td>'); 
						$('#list').append('<td>'+ personDTO.name + '</td>'); 
						$('#list').append('<td>'+ personDTO.age + '</td>'); 
						$('#list').append('</tr>'); 
					 });
				 },
				 error: function(){
					 alert('오류 발생');
				 }
			 });
		 }
	 });
</script>
</head>
<body>
	<form>
		이름<input type="text" id="name" /><br>
		나이<input type="text" id="age"/><br> 
		<input type="button" value="전송" id="btn" />
	</form><br><br>
	<div id="content"></div>	<hr>
	<input type="button" id="btnList" value="리스트"/> 
	<h3>사용자 목록</h3>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>나이</td>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
	
	
</body>
</html>