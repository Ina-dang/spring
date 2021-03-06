<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2022. 4. 27.오전 11:40:20</title>
</head>
<body>
<h1>sample/all</h1>
<a href="member">member</a>
<a href="admin">admin</a>

<sec:authentication property="principal" var="p"/>
<h2>principal : ${p}</h2>
<h2>principal : ${p == 'annoymousUser'}</h2>
<%-- <h2>principal : ${p.member}</h2> --%>
<sec:authorize access="isAnonymous()">
	<h3>비로그인</h3>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<h3>로그인</h3>
	<sec:authorize access="hasRole('ROLE_ADMIN') and hasRole('ROLE_MEMBER')">
		<h3>관리자</h3>
	</sec:authorize>
</sec:authorize>
<sec:authorize access="isFullyAuthenticated()">
	<h3>remember-me가 아님</h3>
</sec:authorize>

</body>
</html>