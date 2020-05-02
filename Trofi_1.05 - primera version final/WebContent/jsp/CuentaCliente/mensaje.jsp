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
	<h1>Mensaje</h1>	
	<table>
		<tr>
			<td align="center"><c:out value="${mensaje}"/></td>
		</tr>
		<tr>
			<td align="center"><a href="menuCliente?action=sesionIniciada&sesionCliente=<c:out value="${correo}" />&desdePedido=<c:out value="${desdePedido}"/>&direccion=<c:out value="${direccion}"/>">Aceptar</a> </td>
		</tr>
	</table>