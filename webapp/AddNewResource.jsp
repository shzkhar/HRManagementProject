<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddNewResource</title>
<style>
.color{
color:red;
}
</style>
</head>
<body align="center">
<%
String name =(String) request.getAttribute("name");
String email =(String) request.getAttribute("email");
String mobno = (String)request.getAttribute("mobno");
String gender =(String) request.getAttribute("gender");
String[] language =(String[]) request.getAttribute("language"); 
String[] database =(String[]) request.getAttribute("database");
String[] technology = (String[])request.getAttribute("technology");
String experience = (String)request.getAttribute("experience");
String resumeurl =(String) request.getAttribute("resumeurl");
String qualification = (String)request.getAttribute("qualification");
%>

<h1>Form For Add New Resource</h1>
     <form action="AddNewResourceController" method="post">
          Enter Name :- <input type="text" name="name" placeholder="Enter Name"/> 
          <span class="color"><%=name==null?"":name %></span>
          <br><br>
          Enter Email :- <input type="text" name="email" placeholder="Enter Email"/>
           <span class="color"><%=email==null?"":email %></span>
          <br><br>
          Enter Mobno :- <input type="text" name="mobno" placeholder="Enter MobileNo"/>
           <span class="color"><%=mobno==null?"":mobno %></span>
          <br><br>
          Enter Gender :- <input type="radio" name="gender" value="M"/>Male 
                          <input type="radio" name="gender" value="F"/>FeMale
            <span class="color"><%=gender==null?"":gender %></span>              
                           <br><br>
          <label for="language">Select Language :-</label>
                             <select name="language" id="language" multiple="multiple" required >
                                <option value="C">C</option>
                                <option value="C#">C#</option>
                                <option value="Java">Java</option>
                                <option value="PHP">PHP</option>
                                <option value="Python">Python</option>
                                <option value="Ruby">Ruby</option> 
                             </select> 
             <span class="color"><%=language==null?"":language %></span>                 
                              <br><br>
                             
           <label for="database">Select Database :-</label>
                             <select name="database" id="database" multiple="multiple" required >
                                <option value="Oracle DB">Oracle DB</option>
                                <option value="MSSQL">MSSQL</option>
                                <option value="MangoDB">MangoDB</option>
                                <option value="MYSQL">MYSQL</option>
                  
                             </select>  
               <span class="color"><%=database==null?"":database %></span>               
                             <br><br>
                             
           <label for="technology">Select Technology :-</label>
                             <select name="technology" id="technology" multiple="multiple"  required>
                                <option value="C">C</option>
                                <option value="C#">C#</option>
                                <option value="Java">Java</option>
                                <option value="PHP">PHP</option>
                                <option value="Python">Python</option>
                                <option value="Ruby">Ruby</option> 
                             </select>  
               <span class="color"><%=technology==null?"":technology %></span>               
                             <br><br>
                                                
         
          Enter Experience :- <input type="text" name="experience" placeholder="Experience In Yr"/>
           <span class="color"><%=experience==null?"":experience %></span>
          <br><br>
          Enter Qualification :- <input type="text" name="qualification" placeholder="Enter Qualification"/>
           <span class="color"><%=qualification==null?"":qualification %></span>
          <br><br>
          Enter Resume URL :- <input type="text" name="resumeurl" placeholder="Enter Url"/>
           <span class="color"><%=resumeurl==null?"":resumeurl %></span>
          <br><br>
          
          <input type="submit" value="SUBMIT"/>
          
     </form>
</body>
</html>