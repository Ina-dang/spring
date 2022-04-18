<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Register</h1>
	<form method=post>
		<h4><label for="title">title</label></h4>
		<input id="title" name="title">
		
		<h4><label for="content">content</label></h4>
		<textarea rows="20" cols="40" name="content" id="content"></textarea>
		
		
		<h4><label for="writer">writer</label></h4>
		<input id="writer" name="writer">
		
		<hr>
		<button type="submit">작성</button>
		<button type="reset">취소</button>
	</form>
</body>
</html>