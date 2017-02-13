<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/theme.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


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
            <li><a href="index.jsp">View Cars</a></li>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
          	<% if (userLogin.getUsername() == null) {%>
          		<li><a href="signup.jsp">Sign Up</a>
            	<li><a href="login.jsp">Login</a></li>
            <%}else{ %>
	        
	          
	          	<li><a href="ProfileController">Welcome, <%=userLogin.getUsername() %></a></li>
            	<li><a href="LogInController">Logout</a></li>
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