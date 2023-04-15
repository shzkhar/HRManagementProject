<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" import="com.bean.HrBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<h2>List Of Hr</h2>
    <% ArrayList<HrBean> hrBeanAL = (ArrayList<HrBean>) request.getAttribute("hrBeanAL"); %>
    
     <a href="Search.jsp">Search</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
     <a href="AdminDashBoard.jsp">AdminDashBoard</a><br><br>
    <table align="center" border ="1">
         <tr>
             <th>HrId</th>
             <th>HrName</th>
             <th>HrEmail</th>
             <th>HrPass</th>
             <th>HrMobno</th>
             <th>Action</th>
         </tr>
        
         <%
                for(HrBean user : hrBeanAL){ 
         %>
        
         <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getHrname()%></td>
            <td><%=user.getHremail()%></td>
            <td><%=user.getHrpassword()%></td>
            <td><%=user.getHrmobno()%></td>
            <td><a href="DeleteHrController?id=<%=user.getId()%>">Delete</a>
            |
            <a href="EditHrController?id=<%=user.getId()%>">Edit</a>
            |
            <a href="ViewHrController?id=<%=user.getId()%>">View</a>
            </td>
            
           
         </tr>
         <%
           } 
         %>
</body>
</html>