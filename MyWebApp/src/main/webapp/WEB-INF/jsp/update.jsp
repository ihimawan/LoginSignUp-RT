<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../jspFragments/headerFooter.jsp" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

<script>

	
    $(document).ready(function() {
    	
    	var carModel = '${carInfo.model}';
    	
    	$("#model").val(carModel);
    	
    /* 	$("#model option[value=" + carModel + "]").prop("selected", "selected") */
    	
    	console.log(carModel);
	
/*     	$(function(){
            $("#updateForm").submit(function(evt){

        		var href = $(this).attr('action');

        		$('#dataConfirmModal').find('.modal-body').text("test");
        		$('#dataConfirmOK').attr('href', href);
        		$('#dataConfirmModal').modal({show:true});
        		
        		return false;


            });
            
        }); */
        
        function fun(){
        	
        }
    	
    	
    });
	
</script>

<div class="container">

		<form class="form-signin" method="post" action="execute" id="updateForm">
			<h2 class="form-signin-heading">Update Car</h2>

			<input type="hidden" name="VIN" value="${carInfo.VIN}" />
			<input type="text" class="form-control" value=${carInfo.VIN} readonly="readonly">

			<select name="model" id="model" placeholder="model"
				class="form-control" required /> 
				
				<%@ include file = "../jspFragments/carModelOptions.jsp" %>
				
			</select>
				
			<input type="number" name="year"
				placeholder="year" class="form-control" value=${carInfo.year} required /> 
				
			<input
				type="number" name="price" placeholder="price" value=${carInfo.price} class="form-control"
				required /> 
				
			<input type="text" name="color" placeholder="color"
				class="form-control" value=${carInfo.color} required /> 
				
			<input type="text"
				name="manufacturer" placeholder="manufacturer" value=${carInfo.manufacturer} class="form-control"
				required /> 
				
			<input
				class="btn btn-lg btn-primary btn-block margintop" type="submit"
				value="Update Car" />
		</form>

		<div class="modal fade" id="dataConfirmModal" tabindex="-1"
			role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true">

			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="dataConfirmLabel">Please Confirm</h3>
					</div>
					<div class="modal-body">...</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal"
							aria-hidden="true">Cancel</button>
						<a class="btn btn-warning btn-ok" id="dataConfirmOK">Update</a>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>