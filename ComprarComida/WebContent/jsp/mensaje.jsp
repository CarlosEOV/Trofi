<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mensaje</title>
</head>
<body>
	<h1>Aviso</h1>	
	<table>
		<tr>
			<td><c:out value="${ mensaje }"/></td>
		</tr>
		<tr>
			<td><a href="menuCliente?action=index" >Ir al menú</a> </td>
			<td><a href="menuCliente?action=mostrarAlimentos&id=<c:out value="${id_cat}" />">Volver</a> </td>
		</tr>
	</table>