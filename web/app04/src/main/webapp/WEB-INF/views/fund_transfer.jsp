<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="transfer" method="post" modelAttribute="transferDto">
	Enter From AccountId : <form:input path="fromAccountId"/> <form:errors path="fromAccountId" class="error"/><br>
	Enter To AccountId : <form:input path="toAccountId"/> <form:errors path="toAccountId" class="error"/><br>
	Enter Amount : <form:input path="amount"/> <form:errors path="amount" class="error"/><br>
	<input type="submit">
</form:form>
</body>
</html>