<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html">
	<title>Taste of India</title>
</head>
<body>
<h2>Welcome to Taste of India</h2>
	<%= "Enter your rewards account number:" %>
	<form method="get" action ="balance">
    	<input type="text" name="account">
    	<input type="submit" value="Check Balance">
	  </form>
	<br />

	${results}
</body>
</html>