<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HrLogin Page</title>
<style>
.color{
color:red;
}
</style>
</head>
<body align="center">

<%String error =(String) request.getAttribute("error"); %>

<span class="color"><%=error==null?"":error %></span> <br><br>
      <h1>Hr Login</h1><br><br>
      <form action="HrAuthenticationController" method="post">
          Enter Email :- <input type="text" name="hremail" placeholder="Enter Email"/><br><br>
          Enter Password :- <input type="password" name="hrpassword" placeholder="Enter Password"/><br><br>
          
          <input type="submit" value="Login"/>
      </form>
     
</body>
</html>