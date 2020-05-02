<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direcciones</title>
</head>
<body>
	<h1>Direcciones</h1>
	<table>
		<tr>
			<td><a href="cuentaCliente?action=mostrarPerfil">Volver al perfil</a></td>
		</tr>
	</table>
	<table border="1" width="100%">
		<tr>
		 <td>Dirección</td>
		 <td>Acción</td>
		</tr>
		<c:forEach var="dir" items="${lista}">
			<tr>
				<td><c:out value="${dir.direccion}"/></td>
				<td><a href="cuentaCliente?action=eliminarDireccion&direccion=<c:out value="${dir.direccion}"/>">Eliminar</a> </td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<td><a href="cuentaCliente?action=nuevaDireccion">Agregar dirección</a></td>
		</tr>
	</table>
</body>
</html>