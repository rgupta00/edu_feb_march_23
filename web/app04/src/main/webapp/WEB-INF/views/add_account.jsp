<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SBI add_account</title>
<style>
.error {
	color: #EF1313;
	font-style: italic;
}
</style>
</head>
<body>
<form:form action="addaccount" method="post" modelAttribute="account">
	<form:hidden path="id"/>
	Enter Name : <form:input path="name"/> <form:errors path="name" class="error"/><br>
	Enter Address : <form:input path="balance"/> <form:errors path="balance" class="error"/><br>
	Enter Email : <form:input path="email"/> <form:errors path="email" class="error"/><br>
	Enter Phone : <form:input path="phone"/> <form:errors path="phone" class="error"/><br>
	<input type="submit">
</form:form>

</body>
</html>