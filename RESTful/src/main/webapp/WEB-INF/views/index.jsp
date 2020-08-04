<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.wrap {	display: flex;}
	.left {width: 500px;}
	.right {width: 600px;}
	label{display: block; margin-top: 10px; margin-bottom: 3px; }
	input[type=text], select{width: 400px; height: 20px;}
	table{border-collapse: collapse;}
	td{border-top:1px solid black;
	 border-bottom: 1px solid black; 
	padding: 5px 10px; text-align: center;}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<script type="text/javascript">
	$(function(){
		userList();
		userSelect();
		userInsert(); 
		userUpdate();
		userDelete();
		init();
	});
	
	/* 사용자목록  */
	function userList(){
		$.ajax({
			url:'users', //@RequestMapping(value="users") 
			type: 'get',  //@RequestMapping(method=RequestMethod.GET)
			dataType: 'json', 
			success: function(response){
				if(response.result == true){
					userListResult(response); 
				}
			},
			error: function(){
				alert('The error just arose ')
			}
		});
	}
	/* 사용자목록 테이블 만들기  */
	function userListResult(response){
		$('tbody').empty();
		var userList = response.userList; 
		$.each(userList, function(i, user){
			$('<tr>')
			.append($('<td>').html(user.userId))
			.append($('<td>').html(user.userName))
			.append($('<td>').html(user.gender))
			.append($('<td>').html(user.address))
			.append($('<td>').html('<button id="btnSelect">조회</button>'))
			.append($('<td>').html('<button id="btnDelete">삭제</button>'))
			.append($('<input type="hidden" id="hidden_userId" />').val(user.userId))
			.appendTo('tbody'); 
		});
	}
	/* 사용자 정보 가져오기 */
	function userSelect(){
		$('body').on('click', '#btnSelect', function(){
			//var userId = $(this).parents('tr').find('#hidden_userId').val();
			var userId = $(this).closest('tr').find('#hidden_userId').val();
			
			$.ajax({
				url:'users/' + userId, //@RequestMapping(value="users/{userId}")
				type:'get',
				dataType:'json',
				success: function(response){
					if(response.result == true){
						userSelectResult(response);
					}
				},
				error: function(){
					alert('The error just arose ')
				}
			});
		});
	}
	/* 4. 사용자 정보 출력 */
	function userSelectResult(response){
		var user= response.userDto; 
		//$('input[type= text][name="userId"]')
		$('input:text[name="userId"]').val(user.userId); 
		$('input:text[name="userName"]').val(user.userName); 
		//$('input:radio[name="gender"][value="남"]').prop('checked',true);
		$('input:radio[name="gender"][value="'+ user.gender + '"]').prop('checked',true); 
		//$('select[name="address"][value="경기"]').prop('selected',true); 
		//$('select[name="address"][value="'+ user.address + '"]').prop('selected',true); 
		$('select[name="address"]').val(user.address).prop('selected',true); 
	}
	/* 5. 사용자 등록  */
	function userInsert(){
		$('#btnInsert').click(function(){
			var userId = $('input:text[name="userId"]').val();
			var userName = $('input:text[name="userName"]').val();
			var gender = $('input:radio[name="gender"]:checked').val();
			var address= $('select[name="address"]').val();
			var obj ={"userId": userId, "userName":userName, "gender":gender,"address":address};
			$.ajax({
				url:'users',
				type:'post', 
				data: JSON.stringify(obj),
				contentType: 'application/json; charset=utf-8',
				dataType: 'json',
				success: function(response){
					if(response.result == 1 ){
						alert('사용자가 등록되었습니다'); 
						userList(); 
					} 
				},
				error: function(){
					alert('The error just arose');
				}
			});
		});
	}
	/* 6. 사용자 수정 */
	function userUpdate(){
		$('#btnUpdate').click(function(){
			var userId = $('input:text[name="userId"]').val();
			var userName = $('input:text[name="userName"]').val();
			var gender = $('input:radio[name="gender"]:checked').val();
			var address= $('select[name="address"]').val();
			var obj ={"userId": userId, "userName":userName, "gender":gender,"address":address};
			$.ajax({
				url: 'users',
				type: 'put',
				data: JSON.stringify(obj),
				contentType: 'application/json; charset=utf-8',
				dataType: 'json',
				success: function(response){
					if(response.result == 1 ){
						alert('사용자 정보가 변경되었습니다'); 
						userList(); //목록갱신
					} 	
				},
				error: function(){
					alert('The error just arose');
				}	
			});
		});
	}	
		/* 7. 사용자삭제  */
		function userDelete(){
			$('body').on('click','#btnDelete', function(){
				var userId = $(this).closest('tr').find('#hidden_userId').val(); 
				var check =confirm(userId +'님의 정보를 삭제 할까요?'); 
				if (check){
					$.ajax({
						url:'users/'+ userId,
						type: 'delete',
						dataType:'json',
						success: function(response){
							if(response.result == 1 ){
								alert(userId +'님의 정보가 삭제 되었습니다'); 
								userList(); //목록갱신
							} 	
						},
						error: function(){
							alert('The error just arose');
						}
					});
				}
			})
		}
	/* 초기화 */
	function init() {
		$('#btnInit').click(function(){
			$('input:text[name="userId"]').val('');
			$('input:text[name="userName"]').val('');
			$('input:radio[name="gender"]').prop('checked', false);
			$('select[name="address"]').val('');
			userList();
		});
	}
</script>
</head>
<body>
	<div class ="wrap">
		<div class="left">
			<h3>사용자 등록/수정</h3>
			<label>아이디</label>
			<input type="text" name="userId" /><br/>
			<label>이름</label>
			<input type="text" name="userName" /><br/>
			<label>성별</label>
			<input type="radio" name="gender" value="m" />남<br/>
			<input type="radio" name="gender" value="f" />여<br/>
			<label>주소</label>
			<select name="address">
				<option value="Seoul">서울</option>
				<option value="Gimpo">김포</option>
				<option value="Incheon">인천</option>
				<option value="Busan">부산</option>
				<option value="Jeju">제주</option>
			</select><br>
			<input type="button" value="등록" id="btnInsert"/>
			<input type="button" value="수정" id="btnUpdate"/>
			<input type="button" value="초기화" id="btnInit"/>
			
		</div>
		<div class="right">
			<h3>사용자목록</h3>
			<table>
				<thead>
					<tr><td>아이디</td><td>이름</td><td>성별</td>
						<td>주소</td><td colspan="2">비고</td></tr>		
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
	
</body>
</html>