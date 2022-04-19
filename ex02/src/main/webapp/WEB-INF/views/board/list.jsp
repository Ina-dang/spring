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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	var result = '${result}';
	check(result);
	function check(result) {
		if(!result || history.state) return;
		
		if (parseInt(result) > 0) {
			alert(result + '번 게시글이 작성되었습니다');
		}
	}
	history.replaceState({}, null, null);
});
</script>
</head>
<body>
	<h1>list page</h1>
	<a href="register${page.cri.params}" >글작성</a>
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
			<td><a href="get${page.cri.params}&bno=${b.bno}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.regDate}</td>
			<td>${b.updateDate}</td>
		</tr>
		</c:forEach>
	</table>
	<c:if test="${page.prev}">
		<a href="list?pageNum=${page.start-1}&amount=${page.cri.amount}">prev</a>
	</c:if>
	<c:forEach begin="${page.start}" end="${page.end}" var="p">
			<a href="list?pageNum=${p}&amount=${page.cri.amount}">${p}</a>
	</c:forEach>
	<c:if test="${page.next}">
		<a href="list?pageNum=${page.end+1}&amount=${page.cri.amount}">next</a>
	</c:if>
</body>
</html>