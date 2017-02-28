<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="com.car.hib.dto.Car"%>

<%@ include file="WEB-INF/jspFragments/headerFooter.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Car Menu</title>
</head>

<body>

    <script>
        
        $(document).ready(function() {
        	$('a[data-confirm]').click(function(ev) {
        		var href = $(this).attr('href');

        		$('#dataConfirmModal').find('.modal-body').text("Are you sure to delete car with VIN =  " + $(this).attr('data-confirm') + "?");
        		$('#dataConfirmOK').attr('href', href);
        		$('#dataConfirmModal').modal({show:true});
        		
        	
        		
        		return false;
        	});
        });
    </script>

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
			<label for="model" class="sr-only">Password</label> 
			
			<select
				name="model" class="form-control">
				
				<%@ include file = "WEB-INF/jspFragments/carModelOptions.jsp" %>

			</select>
			<button class="btn btn-lg btn-primary" type="submit">Search
				&raquo;</button>
		</form>
		</p>
	</div>

	<div>

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
					<th>Manufacturer</th>
					<th>Options</th>
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
					<td><%=car.getManufacturer() %></td>
					<td>
						<a href="car/update/<%=car.getVIN() %>">Update</a> / 
						<%-- <a href=# data-href="car/delete/<%=car.getVIN() %>" data-toggle="modal" data-target="#confirm-delete">Delete</a> / --%>
						<a href="car/delete/<%=car.getVIN() %>" data-confirm="<%=car.getVIN() %>">Delete</a> /
						<a href="rest/car/view/<%=car.getVIN() %>" target="blank">JSON</a>
					</td>
				</tr>
				<%
						}
					}
				%>
				
				<tr>
					<td colspan="4"><a href="jersey/car/model/<%=request.getParameter("model") %>" target="blank">
					Get JSON file for table.</a></td>
				</tr>
				
				<%
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
	
	<div class="modal fade" id="dataConfirmModal" tabindex="-1" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true">
		
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="dataConfirmLabel">Please Confirm</h3>
				</div>
				<div class="modal-body">
					...
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
					<a class="btn btn-danger btn-ok" id="dataConfirmOK">Delete</a>
				</div>
			</div>
		</div>
	</div>

</div>	
</body>


</html>