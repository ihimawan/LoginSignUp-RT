<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="jspFragments/headerFooter.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User profile</title>
</head>
<body>

	<jsp:useBean id="userAddress" scope="request"
		class="com.car.dto.Address" />
	<jsp:useBean id="userProfile" scope="request"
		class="com.car.dto.Profile" />

	<div class="container">
		<div class="jumbotron">
			<h1>
				Hello,
				<%=userLogin.getUsername() %>
				!
			</h1>
			<p>This is your profile page.</p>
		</div>

		<table class="table table-bordered">
			<tr class="active">
				<th colspan=2>Address</td>
			</tr>
			<tr>
				<th>Street</th>
				<td><%=userAddress.getStreet() %></td>
			</tr>
			<tr>
				<th>State</th>
				<td><%=userAddress.getState() %></td>
			</tr>
			<tr class="active">
				<th colspan=2>Profile</td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><%=userProfile.getGender() %></td>
			</tr>
		</table>

	</div>

</body>
</html>