<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bean.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <%AdminBean adminBean = (AdminBean)request.getAttribute("adminBean"); %>
      <h3 align="right">
      <%=adminBean.getEmail()%></h3>
      
      <a href="AddHr.jsp">Add Hr</a>
      <a href="HrListController">Hr List</a>
       <a href="">Resource List</a>
</body>
</html>