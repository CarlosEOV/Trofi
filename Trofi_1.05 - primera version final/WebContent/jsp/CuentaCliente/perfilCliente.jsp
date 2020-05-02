<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfil Cliente</title>
</head>
<body>
<h1>PerfilCliente</h1>
		<table>
			<tr>
				<td><label>Nombre</label></td>
				<td><c:out value="${nombre}"/></td>
			</tr>
			<tr>
				<td><label>Apellido paterno</label></td>
				<td><c:out value="${paterno}"/></td>
			</tr>
			<tr>
				<td><label>Apellido materno</label></td>
				<td><c:out value="${materno}"/></td>
			</tr>
			<tr>
				<td><label>Correo electrónico</label></td>
				<td><c:out value="${correo}"/></td>
			</tr>
			<tr>
				<td><label>Teléfono</label></td>
				<td><c:out value="${telefono}"/></td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td><a href="cuentaCliente?action=direcciones">Direcciones</a></td>
				<td><a href="cuentaCliente?action=mostrarActualizarCuenta">Actualizar</a></td>
				<td><a href="menuCliente?action=sesionIniciada" >Ir al menú</a> </td>
				<td><a href="menuCliente?action=cerrarSesion" >Cerrar Sesión</a> </td>
			</tr>
		</table>
</body>
</html>