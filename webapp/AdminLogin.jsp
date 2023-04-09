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

<%
String email = (String)request.getAttribute("email1");
String password =(String) request.getAttribute("password1");
%>
     <form action="AdminAuthenticationController" method="post">
           Enter Email :- <input type="text" name="email" value="${emailvalue}"/> <br><br>
           <span class="color"><%= email==null?"":email%></span>
        Enter Password :-<input type="text" name="password" value="${passwordvalue}" /><br><br>
          <span class="color"><%=password==null?"":password %></span>
        
          <input type="submit" value="Login"/>
     </form>
</body>
</html>