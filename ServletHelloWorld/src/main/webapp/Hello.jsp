<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("username");
	out.print("chào bạn " + name);
	session.setAttribute("user", name);
	session.setMaxInactiveInterval(10);
	%>>
	<a href="second.jsp"> mở trang 2 </a>
</body>
</html>