<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
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
</head><body>
<div class="wrap">
	<form method="post">
		<h3>기존 내용</h3>
		작성자 : ${sDTO.bWriter} <br/>
		제목 : ${sDTO.bTitle} <br/>
		내용 : ${sDTO.bContent} <br/>
		<h3>수정할 내용</h3>
		제목 <input type="text" name="bTitle" value="${sDTO.bTitle}" /><br/>
		내용 <input type="text" name="bContent" value="${sDTO.bContent}" /><br/>
		<input type="hidden" name="bNo" value="${sDTO.bNo}" />
		<input type="button" value="변경된 내용 수정하기" onclick="fn_update(this.form)" />
		<input type="button" value="삭제하기" onclick="fn_delete(this.form)" />
		<input type="button" value="전체목록 이동하기" onclick="location.href='simpleListPage'" />
	</form>
</div>
</body>
</html>



