<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar cuenta</title>
</head>
<body>
<h1>Actualizar cuenta</h1>
	<form action="cuentaCliente?action=actualizarCuenta" method="post" >
		<table>
			<tr>
				<td><a href="cuentaCliente?action=mostrarPerfil">Volver al perfil</a></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre"  title="Ingresa tu nombre" required="" value="<c:out value="${nombre}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Apellido paterno</label></td>
				<td><input type="text" name="paterno" title="Ingresa tu apellido paterno" required="" value='<c:out value="${paterno}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Apellido materno</label></td>
				<td><input type="text" name="materno" title="Ingresa tu apellido materno" required=""  value='<c:out value="${materno}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Telefono</label></td>
				<td><input type="text" name="telefono" title="Ingresa un número telefónico" minlength="10" maxlength="10" required="" value='<c:out value="${telefono}"></c:out>' ></td>
			</tr>
		</table>
	
		<input type="submit" name="guardar" value="Guardar"> 
	</form>

</body>
</html>