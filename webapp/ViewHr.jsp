<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
      
      <a href="HrListController">Back</a>
     <h2>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; Hr Details</h2>
    <pre><h2>
    HrId    :- ${hrBean.id};
    HrName  :- ${hrBean.hrname};
    HrEmail :- ${hrBean.hremail};
    HrPass  :- ${hrBean.hrpassword};
    HrMobno :- ${hrBean.hrmobno};
    </h2></pre>
</body>
</html>