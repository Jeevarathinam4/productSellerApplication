<%@page import="java.util.Base64" %>
<%@page import="dto.Productdto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 

<%Productdto p = (Productdto)request.getAttribute("products") ;%>

 <form action="update" method ="post">
  id <input type="text" name="id" value="<%=p.getId()%>" readonly="true"><br>
  name<input type="text" name="name" value="<%=p.getName()%>"><br>
  price <input type="text" name="price" value="<%=p.getPrice()%>"><br>
  brand <input type="text" name="brand" value="<%=p.getBrand()%>"><br>
  discount <input type="text" name="discount" value="<%=p.getDiscount()%>"><br>
  
  <%String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
  <img src="data:image/jpeg;base64,<%=base64image %>">
  
  <tr>image <input type="file" name="image" value="<%= p.getImage()%>"></tr>
  <input type="submit">
</form>
</body>
</html>