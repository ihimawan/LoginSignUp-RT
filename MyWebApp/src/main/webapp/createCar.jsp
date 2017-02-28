<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="WEB-INF/jspFragments/headerFooter.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">

		<form class="form-signin" method="post" action="car/add">
			<h2 class="form-signin-heading">Create/Update Car</h2>

			<input type="text" name="VIN" placeholder="VIN" class="form-control"
				required /> 
				
			<select name="model" placeholder="model"
				class="form-control" required /> 
				
				<%@ include file = "WEB-INF/jspFragments/carModelOptions.jsp" %>
				
			</select>
				
			<input type="number" name="year"
				placeholder="year" class="form-control" required /> 
				
			<input
				type="number" name="price" placeholder="price" class="form-control"
				required /> 
				
			<input type="text" name="color" placeholder="color"
				class="form-control" required /> 
				
			<input type="text"
				name="manufacturer" placeholder="manufacturer" class="form-control"
				required /> 
				
			<input
				class="btn btn-lg btn-primary btn-block margintop" type="submit"
				value="Create/Update Car" />
		</form>

	</div>

</body>
</html>