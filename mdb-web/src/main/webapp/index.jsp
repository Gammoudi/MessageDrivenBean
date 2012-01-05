<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tuto Ejb</title>
</head>
<body>
<form action="MessageServlet">
<h1>Please enter the updated information</h1>
<table>
<tr>
<td>User Name:</td>
<td><input type="text" name="username" size="30"></td>
</tr>
<tr>
<td>Old Address:</td>
<td><input type="text" name="oldaddress" size="30"></td>
</tr>
<tr>
<td>New Address:</td>
<td><input type="text" name="newaddress" size="30"></td>
<tr>
</table>
<input type="submit" value="Submit">
</form>
</body>
</html>