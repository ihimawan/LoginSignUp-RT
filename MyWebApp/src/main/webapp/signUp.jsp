<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="WEB-INF/jspFragments/headerFooter.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up!</title>
</head>
<body>

	<script>
		
		function fun(){
			
			var hasError = false;
			
 			var password = document.getElementById("inputPassword").value;
			var repeatpass = document.getElementById("inputRepeatPassword").value;

			if (password!=repeatpass){
				$("#divRepeat").addClass("has-error");
				$("#passErrorText").html("Password does not match.");
				hasError=true;
			}else{
				$("#divRepeat").removeClass("has-error").addClass("has-success");
				$("#passErrorText").html("Password matches!");
				hasError=false;
			}
			
			return !hasError;
			
		}
	</script>

	<div class="container">

		<form class="form-signin" onsubmit="return fun()" method="POST" action="SignUpController">

			<h2 class="form-signin-heading">Sign Up!</h2>

			<label for="inputUsername" class="sr-only">Username</label> 
			<input
				type="text" id="inputUsername" class="form-control"
				placeholder="Username" name = "inputUsername" required autofocus> 
				
			<label
				for="inputPassword" class="sr-only">Password</label> 
			<input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" name = "inputPassword" onChange="fun();" required> 
				
			<div class="form-group" id="divRepeat">
			
				<label
					for="inputRepeatPassword" class="sr-only">Repeat Password</label> 
				<input
					type="password" id="inputRepeatPassword" class="form-control"
					placeholder="Repeat Password" name = "inputRepeatPassword" onChange="fun();" required> 
				<span id="passErrorText" class="help-block"></span>
			</div>
				
			<label
				for="inputStreet" class="sr-only">Street</label> 
			<input type="text"
				id="inputStreet" class="form-control" name = "inputStreet" placeholder="Street" required>

			<label for="inputState" class="sr-only">State</label> 
			<select
				id="inputState" class="form-control" name = "inputState">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">District Of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select>

			<div class="form-control">
				<div class="form-check form-check-inline">
					<label class="form-check-label"> <input
						class="form-check-input" type="radio" name="inputGender"
						id="inputGender" value="Male"> Male
					</label>
				</div>
				<div class="form-check form-check-inline">
					<label class="form-check-label"> <input
						class="form-check-input" type="radio" name="inputGender"
						id="inputGender" value="Female"> Female
					</label>
				</div>
			</div>


			<button data-toggle="tooltip" data-placement="left" class="btn btn-lg btn-primary btn-block" type="submit">Sign Up!</button>
		</form>

	</div>
</body>
</html>