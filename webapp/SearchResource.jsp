<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchResource</title>
<style>
.color{
color:red;
}
</style>
</head>
<body align="center">

       <h2>Search By Name</h2>
       
       <%String msg = (String)request.getAttribute("msg"); %>

<span class="color"><%=msg==null?"":msg %></span><br>
       
       <form action="SearchResourceController" method="post">
          Enter Name :- <input type="text" name="name"/>
          <input type="submit" value="SEARCH"/>
       </form>
</body>
</html>