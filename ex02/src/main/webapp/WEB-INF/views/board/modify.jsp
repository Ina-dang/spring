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
	<h1>Modify</h1>
	${board}
	<form method=post>
		<input type="hidden" name="bno" value="${board.bno}"> 
		<h4><label for="title">title</label></h4>
		<input id="title" name="title" value="${board.title}">
		
		<h4><label for="content">content</label></h4>
		<textarea rows="20" cols="40" name="content" id="content" >${board.content}</textarea>
		
		
		<h4><label for="writer">writer</label></h4>
		<input id="writer" name="writer" value="${board.writer}">
		<input type="hidden" name="pageNum" value="${cri.pageNum}">
		<input type="hidden" name="amount" value="${cri.amount}">
		<hr>
		<button type="submit">수정</button>
		<button type="submit" formaction="remove">삭제</button>
		<a href="list${cri.params}">취소</a>
	</form>
</body>
</html>