<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/theme.css"> <!-- DOES NOT WORK??? WHY??? -->

<style>

@CHARSET "UTF-8";

body {
	  padding-bottom: 20px;
	  margin-bottom: 20px;
	}
	
.navbar {
	  margin-bottom: 20px;
	}
	
.form-control {
	  position: relative;
	  height: auto;
	  -webkit-box-sizing: border-box;
	     -moz-box-sizing: border-box;
	          box-sizing: border-box;
	  padding: 10px;
	  font-size: 16px;
	  margin-bottom: 10px;
}

/* Custom page CSS
-------------------------------------------------- */
/* Not required for template or sticky footer method. */

body > .container {
  padding: 60px 15px 0;
}
.container .text-muted {
  margin: 20px 0;
}

.footer > .container {
  padding-right: 15px;
  padding-left: 15px;
}

code {
  font-size: 80%;
}

/* Sticky footer styles
-------------------------------------------------- */
.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 60px;
  background-color: #f5f5f5;
}

html {
  position: relative;
  min-height: 100%;
}

/* Signup
-------------------------------------------------- */

.form-signin {
  max-width: 500px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}

.form-signin .form-control:focus {
  z-index: 2;
}

.form-signin{
  margin-bottom: -1px;

}

</style>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>




</head>

<body>

<jsp:useBean id="userLogin" scope="session" class="com.ih.code.UserLogin" />

<%

System.out.println(userLogin.getUsername());

%>

<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home.jsp">Yas</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/MyWebApp/index.jsp">View Cars</a></li>
            <li><a href="/MyWebApp/createCar.jsp">Add Cars</a></li>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
          	<% if (userLogin.getUsername() == null) {%>
          		<li><a href="/MyWebApp/signUp.jsp">Sign Up</a>
            	<li><a href="/MyWebApp/login.jsp">Login</a></li>
            <%}else{ %>
	        
	          
	          	<li><a href="/MyWebApp/ProfileController">Welcome, <%=userLogin.getUsername() %></a></li>
            	<li><a href="/MyWebApp/LogInController">Logout</a></li>
            <%} %>
           	
         </ul>
          </ul>

        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <footer class="footer">
      <div class="container">
        <p class="text-muted">&copy;2017 Indri Himawan</p>
      </div>
    </footer>
    
    
</body>

</html>