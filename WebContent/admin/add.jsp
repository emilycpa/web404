<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
<form action="productAction?reqType=1" method="post">
url:<input type="text" name="url" size="100" /><br>
name:<input type="text" name="name"  /><br>
desc:<input type="text" name="desc"  /><br>
code:<input type="text" name="code" /><br>
bss:<input type="text" name="bss" /><br>
ecs:<input type="text" name="ecs" /><br>
type:<input type="text" name="type" /><br>
image:<input type="text" name="imgUrl" /><br>
<input type="submit" value="add">
</form>
</body>
</html>