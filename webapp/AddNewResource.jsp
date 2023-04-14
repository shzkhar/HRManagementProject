<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <form action="" method="post">
          Enter Name :- <input type="text" name="name" placeholder="Enter Name"/>
          Enter Email :- <input type="text" name="email" placeholder="Enter Email"/>
          Enter Mobno :- <input type="text" name="mobno" placeholder="Enter MobileNo"/>
          Enter Gender :- <input type="radio" name="gender" value="M"/>Male 
                          <input type="radio" name="gender" value="F"/>FeMale <br><br>
          Select Language :- <select class="js-example-basic-multiple" name="states[]" multiple="multiple">
                                <option value="AL">Alabama</option>
    
                                <option value="WY">Wyoming</option>
                             </select>  
          Enter Experience :- <input type="text" name="experience" placeholder="Experience In Yr"/>
          Enter Resume URL :- <input type="text" name="url" placeholder="Experience In Yr"/>
          
     </form>
</body>
</html>