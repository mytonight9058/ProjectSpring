<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="modify" method="post">
		<table>
			<tr>
				<td>프로젝트 이름</td>
				<td><input type="text" name="title" value="${list.title}">
				<input type="hidden" name="no" value="${list.no}"></td>
			</tr>
			<tr>
				<td>프로젝트 내용</td>
				<td><textarea name="content" rows="10" cols="60">${list.content}</textarea></td>
			</tr>
			<tr>
				<td>시작날짜</td> <fmt:formatDate var="s_date" pattern="yyyy-MM-dd" value="${list.start_date}"></fmt:formatDate>
				<td><input type="date" name="start_date" value="${s_date}" class = "date"></td>
			</tr>
			<tr>
				<td>마감날짜</td> <fmt:formatDate var="e_date" pattern="yyyy-MM-dd" value="${list.end_date}"></fmt:formatDate>
				<td><input type="date" name="end_date" value="${e_date}" class = "date"></td>
			</tr>
			<tr>
				<td>상태</td>
				<td><select name="state">
						<option value = "준비">준비</option>
						<option value = "진행중">진행중</option>
						<option value = "종료">종료</option>
						<option value = "보류">보류</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"> <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>