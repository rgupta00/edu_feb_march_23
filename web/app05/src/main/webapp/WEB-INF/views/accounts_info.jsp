<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="addaccount">add new Account</a><br/>
	<a href="transfer">fund transfer</a><br/>
	<a href="deposit">fund deposit</a><br/>
	<a href="withdraw">fund withdraw</a><br/>
	
	<table border=1>
		<thead>
			<tr>
				<th>Account id</th>
				<th>name</th>
				<th>balance</th>
				<th>email</th>
				<th>phone</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.id }</td>
					<td>${account.name}</td>
					<td>${account.balance}</td>
					<td>${account.email}</td>
					<td>${account.phone}</td>
					<td><a href="update?id=${account.id }">update</a></td>
					<td><a href="delete?id=${account.id}">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>


