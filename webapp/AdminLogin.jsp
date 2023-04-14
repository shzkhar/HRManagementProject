<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<style>
  .color{
  color:red;'
  }
</style>
</head>
<body align="center">
<h2>Admin Login </h2>
<%
String email = (String)request.getAttribute("email1");
String password =(String) request.getAttribute("password1");
String error = (String) request.getAttribute("error");
%>
<span class="color"><%=error==null?"":error %></span><br><br>
<br>
     <form action="AdminAuthenticationController" method="post">
           Enter Email :- <input type="text" name="email" value="${emailvalue}"/> 
           <span class="color"><%= email==null?"":email%></span><br><br>
        Enter Password :-<input type="text" name="password" value="${passwordvalue}" />
          <span class="color"><%=password==null?"":password %></span><br><br>
        
          <input type="submit" value="Login"/>
     </form>
</body>
</html>