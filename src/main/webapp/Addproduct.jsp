<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Saveproduct" method="post" enctype="multipart/form-data">
   id <input type="text" name ="id" ><br>
   name <input type="text" name ="name" ><br>
   price <input type="text" name ="price" ><br>
   brand <input type="text" name ="brand" ><br>
   discount <input type="text" name ="discount" ><br>
   image <input type="file" name ="image" ><br>
   <input type="submit">
</form>

</body>  
</html>