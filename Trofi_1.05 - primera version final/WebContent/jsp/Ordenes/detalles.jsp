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
	<h1>Detalles</h1>
	
	<table border="1" width="100%">
		<tr>
		 <td> CLIENTE</td>
		 <td> NOMBRE</td>
		 <td> DESCRIPCION </td>
		 <td> COSTO </td>
		</tr>
		<c:forEach var="alimento" items="${lista}">
			<tr>
				<td><c:out value="${cliente}"/></td>
				<td><c:out value="${alimento.nombre}"/></td>
				<td><c:out value="${alimento.descripcion}"/></td>
				<td><c:out value="${alimento.costo}"/></td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<td><a href="muestra_orden?action=verOrdenes" >Ver Ordenes </a> </td>
			<td><a href="muestra_orden?action=verOrdenesAceptadas" >Ver Ordenes Aceptadas </a> </td>
		</tr>
	</table>
	
</body>
</html>