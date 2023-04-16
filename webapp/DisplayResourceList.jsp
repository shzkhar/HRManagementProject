<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"  import="com.bean.ResourceBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
     <%ArrayList<ResourceBean> resourceBeanAL =(ArrayList<ResourceBean>) request.getAttribute("resourceBeanAL"); %>
     <h2>List Of All Resource</h2>
      <a href="SearchResource.jsp">Search</a><br><br>
     <table border="1" align="center">
          <tr>
             <th>Id</th>
             <th>Name</th>
             <th>Email</th>
             <th>Mobno</th>
             <th>Gender</th>
             <th>Experience</th>
             <th>ResumeURL</th>
             <th>Qualification</th>
             <th>Action</th>
          </tr>
          <%
              for(ResourceBean rb:resourceBeanAL) {
          %>
          <tr>
             <td><%=rb.getId() %></td>
             <td><%=rb.getName() %></td>
              <td><%=rb.getEmail() %></td>
               <td><%=rb.getMobno() %></td>
                <td><%=rb.getGender() %></td>
                 <td><%=rb.getExperience() %></td>
                 <td><%=rb.getResumeurl() %></td>
                 <td><%=rb.getQualification() %></td>
                 <td>
                  <a href="EditResourceController?id=<%=rb.getId() %>">Update</a>
                  |
                  <a href="ViewResourceController?id=<%=rb.getId() %>">View</a>
                  |
                  <a href="DeleteDeleteController?id=<%=rb.getId() %>">Delete</a>
                 </td>
          </tr>
          <%
              }
          %>
     </table>
</body>
</html>