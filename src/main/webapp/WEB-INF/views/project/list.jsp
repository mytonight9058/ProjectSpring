<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
	}
	tabale,th,td{
		border:1px solid black;
	}

</style>
</head>
<body>
	<a href="insert">프로젝트 등록</a>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>상태</th>
		</tr>
	<c:forEach var = "list" items = "${list }">
			<tr>
				<td>${list.no}</td>
				<td><a href="detail?no=${list.no}">${list.title}</a></td>
				<td>${list.start_date}</td>
				<td>${list.end_date}</td>
				<td>${list.state}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>