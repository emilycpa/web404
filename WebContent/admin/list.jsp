<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.database.DataBaseUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<Map<String, Object>> data = DataBaseUtil.queryProduct();
	request.setAttribute("data", data);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CODE</th>
			<th>BSS CODE</th>
			<th>ECS CODE</th>
			<th>DESC</th>
			<th>TYPE</th>
			<th>URL</th>
			<th>IMAGE</th>
			<th>OPERATE</th>
		</tr>
		<c:forEach items="${data}" var="row">
			<tr>
				<td>${row.id}</td>
				<td>${row.name}</td>
				<td>${row.code}</td>
				<td>${row.bss}</td>
				<td>${row.ecs}</td>
				<td>${row.desc}</td>
				<td>${row.type}</td>
				<td>${row.url}</td>
				<td><img alt="" src="${row.imgUrl}" width="50px" /></td>
				<td>
					<a href="edit.jsp?id=${row.id}">edit</a>
					<a href="productAction?reqType=3&id=${row.id}">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>