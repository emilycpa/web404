<%@page import="com.database.po.Product"%>
<%@page import="com.database.DataBaseUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Product product = DataBaseUtil.queryProduct(Integer.parseInt(request.getParameter("id")));
	request.setAttribute("product", product);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<form action="productAction?reqType=2" method="post">
		<input type="hidden" name="id" value="${product.id}" /> <br>
		url:<input type="text" name="url" size="100" value="${product.url}" /><br>
		name:<input type="text" name="name" value="${product.name}" /><br>
		desc:<input type="text" name="desc" value="${product.description}" /><br>
		code:<input type="text" name="code" value="${product.code}" /><br>
		bss:<input type="text" name="bss" value="${product.bssCode}" /><br>
		ecs:<input type="text" name="ecs" value="${product.ecsCode}" /><br>
		type:<input type="text" name="type" value="${product.type}" /><br>
		image:<input type="text" name="imgUrl" value="${product.imgUrl}" /><br>
		<input type="submit" value="edit">
	</form>
</body>
</html>