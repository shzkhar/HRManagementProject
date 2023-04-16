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

       <h1>Search By Name</h1><br>
       
       <%String msg = (String)request.getAttribute("msg"); %>
       <a href="ResourceListController">Viewresource</a><br><br>

<span class="color"><%=msg==null?"":msg %></span><br><br>
       
       <form action="SearchResourceController" method="post">
          Search By Name :- <input type="text" name="name" placeholder="Enter_Name"/>
          <input type="submit" value="SEARCH"/>
       </form>
</body>
</html>