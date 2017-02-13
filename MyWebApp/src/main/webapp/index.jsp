<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="com.car.hib.dto.Car"%>

<%@ include file="jspFragments/headerFooter.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Car Menu</title>
</head>

<div class="container">

	<!-- Main component for a primary marketing message or call to action -->
	<div class="col-xs-6 col-lg-6">
		<h1>View all available Cars</h1>
		<p>View all available cars.</p>
		<p>
		<form method="GET" action="GetController">
			<button class="btn btn-lg btn-primary" type="submit">Go
				&raquo;</button>
		</form>
		</p>
	</div>

	<div class="col-xs-6 col-lg-6">
		<h1>Filter</h1>
		<p>Filter car by model.</p>
		<p>
		<form method="GET" action="GetController">
			<label for="model" class="sr-only">Password</label> <select
				name="model" class="form-control">
				<option value="civic">Civic</option>
				<option value="honda">Honda</option>
				<option value="mercedes">Mercedes</option>
				<option value="audi">Audi</option>
				<option value="antique">Antique</option>
			</select>
			<button class="btn btn-lg btn-primary" type="submit">Search
				&raquo;</button>
		</form>
		</p>
	</div>

	<div>


		<%-- 		<table class="table">
			<thead>
				<tr>
					<th>VIN</th>
					<th>Model</th>
					<th>Price</th>
					<th>Color</th>
				</tr>
			</thead>

			<tbody>
			
				<c:forEach items="${result}" var="item">
					<tr>
						<td>${item.vin}</td>
						<td>${item.model}</td>
						<td>${item.price}</td>
						<td bgcolor="${item.color}">${item.color}</td>
					</tr>
	    		
				</c:forEach>

			</tbody>
			</table> --%>


		<% 
      		Object result = request.getAttribute("result");		
	        if (result!=null){
	        	%>
		<table class="table">
			<thead>
				<tr>
					<th>VIN</th>
					<th>Model</th>
					<th>Price</th>
					<th>Color</th>
				</tr>
			</thead>

			<tbody>

				<%
					
					List<Car> hm = (List<Car>) result;

					if (hm.isEmpty()){
						%>
				<tr>
					<td colspan="4">No cars available.</td>
				</tr>
				<%
					}else{
					
						for(Car car: hm){
							%>
				<tr>
					<td><%=car.getVIN() %></td>
					<td><%=car.getModel() %></td>
					<td><%=car.getPrice() %></td>
					<td bgcolor="<%=car.getColor() %>"><%=car.getColor() %></td>
				</tr>
				<%
						}
					}

	        }else{
	        	%>
				<tr>
					<td colspan="4">Unable to obtain cars.</td>
				</tr>
				<%
	        }%>


			</tbody>
		</table>
	</div>

</div>	

</html>