<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar dirección</title>
</head>
<body>
    <h1>Agregar dirección</h1>
    <form action="cuentaCliente?action=agregarDireccionPedido" method="post">
        <table>
            <tr>
                <td><label>Dirección</label></td>
                <td><input type="text" name="direccion" title="Ingresa una direccion" required=""></td>
            </tr>
        </table>
        <input type="submit" name="agregar" value="Agregar">
        
        <table>
	</table>
    </form>
</body>
</html>
