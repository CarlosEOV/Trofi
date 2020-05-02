<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h1>Categorias</h1>
	<table>
		<tr>
			<td><a href="menu?action=index" >Ir al menú</a> </td>
			<td><a href="menu?action=nuevaCategoria">Agregar</a></td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td> ID</td>
		 <td> NOMBRE</td>
		 <td>ALIMENTOS</td>
		 <td>EDITAR</td>
		 <td>ELIMINAR</td>
		</tr>
		<c:forEach var="categoria" items="${lista}">
			<tr>
				<td><c:out value="${categoria.id}"/></td>
				<td><c:out value="${categoria.nombre}"/></td>
				<td><a href="menu?action=mostrarAlimentos&id=<c:out value="${categoria.id}" />">Seleccionar</a></td>
				<td><a href="menu?action=showEditarCategoria&id=<c:out value="${categoria.id}" />">Seleccionar</a></td>
				<td><a href="menu?action=eliminarCategoria&id=<c:out value="${categoria.id}" />">Seleccionar</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>