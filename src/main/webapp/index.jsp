<html>
<body>

<h1> hello world</h1>
<%String message=(String)request.getAttribute("message"); %>
<%if (message!=null) {%>
<h1><%=message %></h1>
<%} %>
<button><a href="Login.jsp">LOGIN</a></button>
<button><a href="Signup.jsp">SIGNUP</a></button>
</body>
</html>
