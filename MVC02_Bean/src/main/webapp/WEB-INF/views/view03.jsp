<%@page import="com.koreait.mvc02.dto.PersonDTO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view03</title>
</head>
<body>	<% 
	WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application); 
	PersonDTO p1 = ctx.getBean("per", PersonDTO.class);
	PersonDTO p2 = ctx.getBean("per2", PersonDTO.class);
	
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
	%>
	<h1> 사용자</h1>
	<ul><li> ${p1.name }</li><li> ${p1.age }</li>
		<li> ${p1.contact.phone }</li>
		<li> ${p1.contact.addr }</li>
	</ul>
</body>
</html>