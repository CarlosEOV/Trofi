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
	<h1>Comprar Comida</h1>
	<table>
		<tr>
			<td><a href="cuentaCliente?action=mostrarPerfil&correo=<c:out value="${sesionCliente}" />" >Ver tu perfil</a> </td>
		</tr>
	</table>
	
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><a href="menuCliente?action=mostrarCategorias">Menu Categorias</a></td>			
		</tr>
		<tr>
			<td align="center"><a href="menuCliente?action=carrito">Mostrar Carrito</a></td>
		</tr>
	</table>
	
	
</body>
</html>