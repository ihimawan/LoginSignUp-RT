<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="WEB-INF/jspFragments/headerFooter.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<div class="container">

      <form class="form-signin" method="POST" action="LogInController">
      
        <h2 class="form-signin-heading">Log In!</h2>
        
        <% if(request.getAttribute("logoutMessage")!=null){ %>
        	<div class="alert alert-success" role="alert"><%=request.getAttribute("logoutMessage") %></div>
        <% }%>
        
        <% if (request.getAttribute("loginMessage")!=null){ %>
       		<div class="alert alert-danger" role="alert"><%=request.getAttribute("loginMessage") %></div>
       	<%} %>
        
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="Username" name="inputUsername" required autofocus>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="inputPassword" required>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->

</body>
</html>