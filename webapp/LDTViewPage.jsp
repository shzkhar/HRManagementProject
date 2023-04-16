<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% ArrayList languageAL = (ArrayList) request.getAttribute("languageAL");
       ArrayList databaseAL = (ArrayList) request.getAttribute("databaseAL");
       ArrayList technologyAL = (ArrayList) request.getAttribute("technologyAL");
        String check = (String) request.getAttribute("check");
    %>
    
   
       
      
       <pre>
        <%if(check.equals("Language")) {%>
        <h1>  Languages Details  </h1> 
            <%Iterator e = languageAL.iterator();
              while(e.hasNext())
              { %>
            	<h2>      <%=e.next() %> </h2>
              <%} %> 
         <%} %>
      
       <% if(check.equals("Database")) {%>
       
       <h1>  Database Details  </h1> 
            <%Iterator e = databaseAL.iterator();
              while(e.hasNext())
              { %>
            	<h2>      <%=e.next() %> </h2>
              <%} %>
              
       <%} %>
       
       
        <% if(check.equals("Technology")) {%>
       
       <h1>  Database Details  </h1> 
            <%Iterator e = technologyAL.iterator();
              while(e.hasNext())
              { %>
            	<h2>      <%=e.next() %> </h2>
              <%} %>
              
       <%} %>
       
          
           
       </pre>
     
    </table>
</body>
</html>