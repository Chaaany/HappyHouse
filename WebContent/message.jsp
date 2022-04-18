<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message</title>
</head>
<body>
	<%=request.getAttribute("mes")%><br/>
	<a href='<%=request.getAttribute("url")%>'><%=request.getAttribute("con")%></a>   
</body>
</html>