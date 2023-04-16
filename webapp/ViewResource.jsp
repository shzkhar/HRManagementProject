<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="ResourceListController">Back</a>
      <pre><h2>
         ID            :- ${resourceBean.id }
         Name          :- ${resourceBean.name };
         Email         :- ${resourceBean.email };
         Mobno         :- ${resourceBean.mobno };
         Gender        :- ${resourceBean.gender };
         Experience    :- ${resourceBean.experience };
         ResumeURL     :- ${resourceBean.resumeurl };
         Qualification :- ${resourceBean.qualification };
      </h2></pre>
</body>
</html>