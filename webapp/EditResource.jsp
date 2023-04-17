<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditResource Page</title>

</head>
<body>
  
         <form action="EditResourceController" method="post">
             
           <input type="hidden" name="id" value="${param.id}" /> 
          Enter Name :- <input type="text" name="name" value="${resourceBean.name }"/> <br><br>
          Enter Email :- <input type="text" name="email" value="${resourceBean.email }"/><br><br>
          Enter Mobno :- <input type="text" name="mobno" value="${resourceBean.mobno }"/><br><br>
          Enter Gender :- <input type="radio" name="gender" value="M"/>Male 
                          <input type="radio" name="gender" value="F"/>FeMale <br><br>
                          
              <label for="language">Select Language :-</label>
                             <select name="language" id="language" multiple="multiple" required >
                                <option value="C">C</option>
                                <option value="C#">C#</option>
                                <option value="Java">Java</option>
                                <option value="PHP">PHP</option>
                                <option value="Python">Python</option>
                                <option value="Ruby">Ruby</option> 
                             </select> 
                          
                              <br><br>
                             
           <label for="database">Select Database :-</label>
                             <select name="database" id="database" multiple="multiple" required >
                                <option value="OracleDB">OracleDB</option>
                                <option value="MSSQL">MSSQL</option>
                                <option value="MANGODB">MangoDB</option>
                                <option value="MySQL">MYSQL</option>
                  
                             </select>  
                            
                             <br><br>
                             
           <label for="technology">Select Technology :-</label>
                             <select name="technology" id="technology" multiple="multiple"  required>
                                <option value="JSP">JSP</option>
                                <option value="Servlet">Servlet</option>
                                <option value="Hadoop">Hadoop</option>
                                <option value="BigData">BigData</option>
                                <option value="AWS">AWS</option>
                               
                             </select>  
                            
                             <br><br>             
                          
                          
                          
                          
          Enter Experience :- <input type="text" name="experience" value="${resourceBean.experience }"/><br><br>
          Enter Qualification :- <input type="text" name="qualification" value="${resourceBean.qualification }"/><br><br>
          Enter Resume URL :- <input type="text" name="resumeurl" value="${resourceBean.resumeurl }"/><br><br>
          
          <input type="submit" value="UPDATE"/>
         </form>
</body>
</html>
