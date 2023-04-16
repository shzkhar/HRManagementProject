<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchHr</title>
<style>
.color{
color:red;
}
</style>
</head>
<body align="center">
<h2>Search Hr By Name</h2>
<%String msg = (String)request.getAttribute("msg"); %>

<span class="color"><%=msg==null?"":msg %></span><br><br>

     <form action="SearchController" method="post">
          Enter HrName : <input type="text" name="hrname"/>
     <input type="submit" value="Search"/>
     </form>
</body>
</html>