<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mensaje - Trofi</title>
</head>
<body>
	<h1 align="center">Aviso</h1>	
	<table align="center">
		<tr>
			<td><c:out value="${ mensaje }"/></td>
		</tr>
		<tr>
			<td><a href="muestra_orden?action=verOrdenesAceptadas">Aceptar</a> </td>
		</tr>
	</table>
</body>
</html>