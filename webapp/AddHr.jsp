<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Hr</title>
<style>
.color{
   color:red;
}
</style>
</head>
<body align="center">
<h3>Enter Details</h3>
  <%String hrname = (String)request.getAttribute("hrname"); 
  String hremail = (String)request.getAttribute("hremail");
  String hrpassword = (String)request.getAttribute("hrpassword");
  String hrmobno = (String)request.getAttribute("hrmobno");
  String error = (String)request.getAttribute("error");
  %>
  <span class="color"><%= error==null?"":error%></span><br><br>
       <form action="HrRegistrationController" method="post">
        Enter Hr Name :- <input type="text" name="hrname" value="${hrnamevalue}"/> 
           <span class="color"><%= hrname==null?"":hrname%></span><br><br>
        Enter Hr Emial :-<input type="text" name="hremail" value="${hremailvalue}" />
          <span class="color"><%=hremail==null?"":hremail %></span><br><br>
        Enter Hr Password :- <input type="password" name="hrpassword" value="${hrpasswordvalue}"/> 
           <span class="color"><%= hrpassword==null?"":hrpassword%></span><br><br>
        Enter Hr Mobno :-<input type="text" name="hrmobno" value="${hrmobnovalue}" />
          <span class="color"><%=hrmobno==null?"":hrmobno %></span><br><br>
        
          <input type="submit" value="Login"/>
     </form>
         
</body>
</html>