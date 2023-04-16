<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<h1>Form For Add New Resource</h1>
     <form action="AddNewResourceController" method="post">
          Enter Name :- <input type="text" name="name" placeholder="Enter Name"/> <br><br>
          Enter Email :- <input type="text" name="email" placeholder="Enter Email"/><br><br>
          Enter Mobno :- <input type="text" name="mobno" placeholder="Enter MobileNo"/><br><br>
          Enter Gender :- <input type="radio" name="gender" value="M"/>Male 
                          <input type="radio" name="gender" value="F"/>FeMale <br><br>
          <label for="language">Select Language :-</label>
                             <select name="language" id="language" multiple="multiple"  required>
                                <option value="C">C</option>
                                <option value="C#">C#</option>
                                <option value="Java">Java</option>
                                <option value="PHP">PHP</option>
                                <option value="Python">Python</option>
                                <option value="Ruby">Ruby</option> 
                             </select>  <br><br>
                             
           <label for="database">Select Database :-</label>
                             <select name="database" id="database" multiple="multiple" required>
                                <option value="Oracle DB">Oracle DB</option>
                                <option value="MSSQL">MSSQL</option>
                                <option value="MangoDB">MangoDB</option>
                                <option value="MYSQL">MYSQL</option>
                  
                             </select>  <br><br>
                             
           <label for="technology">Select Technology :-</label>
                             <select name="technology" id="technology" multiple="multiple" required >
                                <option value="C">C</option>
                                <option value="C#">C#</option>
                                <option value="Java">Java</option>
                                <option value="PHP">PHP</option>
                                <option value="Python">Python</option>
                                <option value="Ruby">Ruby</option> 
                             </select>  <br><br>
                                                
         
          Enter Experience :- <input type="text" name="experience" placeholder="Experience In Yr"/><br><br>
          Enter Qualification :- <input type="text" name="qualification" placeholder="Enter Qualification"/><br><br>
          Enter Resume URL :- <input type="text" name="resumeurl" placeholder="Enter Url"/><br><br>
          
          <input type="submit" value="SUBMIT"/>
          
     </form>
</body>
</html>