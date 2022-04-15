<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/resources/favicon.ico" type="image/x-icon">
<link rel="icon" href="/resources/favicon.ico" type="image/x-icon">
</head>
<body>
	<h1>list page</h1>
	<table border="1"> 
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>writer</th>
			<th>regDate</th>
			<th>updateDate</th>
		</tr>
		
		<c:forEach items="${boards}" var="b">
		<tr>
			<td>${b.bno}</td>
			<td><a href="get?bno=${bno}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.regDate}</td>
			<td>${b.updateDate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>