<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<c:url value="/entrada?accion=Login" var="linkEntradaServlet"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkEntradaServlet }"  method="post">
	
		Login: <input type="text" name="Login"/>
		Contraseña: <input type="password" name="contrasena"/>
		
		
		<input type="hidden" name="accion" value="Login"/>
		
		<input type="submit"/>
		
	</form>

</body>
</html>