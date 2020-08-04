<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	
	function fn_noticeUpdate(f){
		if(confirm('수정하시겠습니까?')){
			f.action = 'NoticeUpdate';
			f.submit();
		}
	}
	function fn_noticeDelete(f){
		if(confirm('삭제하시겠습니까?')){
			f.action = 'NoticeDelete';
			f.submit();
		}
	}
	
</script>

<!-- 동적인 페이지 포함 -->
<jsp:include page="../template/header.jsp" />

<br/></br>
<div class ="main-menu"> 
<%-- 
		제목 : ${nDTO.n_Title } 
		내용 : {nDTO.n_Content} --%>
		
				
				<!--  loginDTO가 null 일때 ! -->
				<c:if test="${empty mDTO }">
					제목 : ${nDTO.n_Title }  <br>
					내용 : {nDTO.n_Content}	 <br>
					등록일 : ${nDTO.n_Date } <br>
					<input type="button" value="목록으로" onclick="location.href='NoticePage'" />
				</c:if>
				
				<!--  loginDTO가 null 이 아닐때 ! -->
				<c:if test="${not empty mDTO }">
					<c:choose>
						
						<c:when test="${mDTO.m_State eq 1}">
							제목 : ${nDTO.n_Title }  <br>
							내용 : {nDTO.n_Content}	 <br>
							등록일 : ${nDTO.n_Date } <br>
						
						
							<input type="button" value="목록으로" onclick="location.href='NoticePage'" />
						</c:when>
						
						<c:when test="${mDTO.m_State eq 2}">
						 <form method="post">
							<input type="hidden" name="n_No" value="${nDTO.n_No }" />
							제목 : <input type="text" name="n_Title" value="${nDTO.n_Title }" /><br/><br/>
							내용 : <textarea name="n_Content" rows="10" cols="30">${nDTO.n_Content }</textarea><br/><br/>
							등록일 : <input type="text" name="n_Date" value="${nDTO.n_Date }" readonly /><br/><br/>
						</form>
							<input type="button" value="수정하기" onclick="fn_noticeUpdate(this.form)" />
							<input type="button" value="삭제하기" onclick="fn_noticeDelete(this.form)" />
							<input type="button" value="목록으로" onclick="location.href='NoticePage'" />
						</c:when>
		
					</c:choose>
				</c:if>

	
	
	<%-- <form method="post">
			<input type="hidden" name="n_No" value="${nDTO.n_No }" />
			제목 : <input type="text" name="n_Title" value="${nDTO.n_Title }" /><br/><br/>
			내용 : <textarea name="n_Content" rows="10" cols="30">${nDTO.n_Content }</textarea><br/><br/>
			등록일 : <input type="text" name="n_Date" value="${nDTO.n_Date }" readonly /><br/><br/>
				
				<!--  loginDTO가 null 일때 ! -->
				<c:if test="${empty mDTO }">
					<input type="button" value="목록으로" onclick="location.href='NoticePage'" />
				</c:if>
				
				<!--  loginDTO가 null 이 아닐때 ! -->
				<c:if test="${not empty mDTO }">
					<c:choose>
						
						<c:when test="${mDTO.m_State eq 1}">
							<input type="button" value="목록으로" onclick="location.href='NoticePage'" />
						</c:when>
						
						<c:when test="${mDTO.m_State eq 2}">
							<input type="button" value="수정하기" onclick="fn_noticeUpdate(this.form)" />
							<input type="button" value="삭제하기" onclick="fn_noticeDelete(this.form)" />
							<input type="button" value="목록으로" onclick="location.href='NoticePage'" />
						</c:when>
		
					</c:choose>
				</c:if>
	</form>	 --%>
</div>			
<!-- 정적인 페이지 포함 -->
<%@ include file="../template/footer.jsp" %>













