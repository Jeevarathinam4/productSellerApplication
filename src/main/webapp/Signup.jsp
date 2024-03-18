<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if (message!=null) {%>
<h1><%=message %></h1>
<%} %>
<form action="Signup" method="post">
id:<input type="text" name="id"><br>
name:<input type="text" name="name"><br>
contact:<input type="text" name="contact"><br>
email:<input type="text" name="email"><br>
password:<input type="text" name="password"><br>
<input type="submit">


</form>

</body>
</html>