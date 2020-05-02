<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu - Trofi</title>
</head>
<body>
	<h1>Estados Disponibles</h1>
	
	<table border="1" width="100%">
		<tr>
		 <td> ESTADOS</td>
		 <td> CAMBIAR </td>
		</tr>
		<c:forEach var="estados" items="${lista}">
			<tr>
				<td><c:out value="${estados}"/></td>
				<td><a href="muestra_orden?action=aviso&estado=<c:out value="${estados}" />&id_orden=<c:out value="${id_orden}" />&correoCliente=<c:out value="${correoCliente}" />">Aceptar</a></td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<td><a href="muestra_orden?action=verOrdenesAceptadas" >Ordenes Aceptadas </a> </td>
		</tr>
	</table>
	
</body>
</html>