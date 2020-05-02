<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador - Trofi</title>
</head>
<body>
	<h1>Administrador</h1>
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><a href="menu?action=index&sesionAdministrador=<c:out value="${sesionAdministrador}" />"> Ir al menu</a></td>			
			
		</tr>
		<tr>
			<td><c:out value="${sesionAdministrador}"/></td>
		</tr>
	</table>
	
	
</body>
</html>