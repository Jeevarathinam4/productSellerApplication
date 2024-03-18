<%@page import="java.util.Base64" %>
<%@page import="java.util.*" %>
<%@page import="dto.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome</h1>
<a href="Addproduct.jsp">ADD PRODUCT</a>
<table border="2px">
<tr>
<th>id</th>
<th>name</th>
<th>brand</th>
<th>price</th>
<th>discount</th>
<th>image</th>
<th>edit</th>
<th>delete</th>
</tr>
<%List<Productdto>list=(List)request.getAttribute("products"); %>
<%for(Productdto p:list){ %>
<tr>
<td><%=p.getId() %></td>
<td><%=p.getName() %></td>
<td><%=p.getPrice() %></td>
<td><%=p.getBrand() %></td>
<td><%=p.getDiscount() %></td>
<%String base64=new String(Base64.getEncoder().encode(p.getImage())); %>
<td><img src="data:image/jpeg;base64,<%=base64 %>"height="100px"width="100px" src=""></td>
<td><a href="edit?id=<%=p.getId()%>">edit</a></td>
<td><a href="delete?id=<%=p.getId()%>">edit</a></td>

</tr><br>
<%} %>






</table>
<a href="Logout">LOGOUT</a>

</body>
</html>