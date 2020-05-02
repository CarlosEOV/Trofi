<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Repartidor</title>
</head>
<body>
    <h1>Crear Repartidor</h1>
    <form action="alta_repartidor?action=dardeAlta" method="post">
        <table>
            <tr>
                <td><label>Nombre</label></td>
                <td><input type="text" name="nombre" title="Ingresa tu nombre" required=""></td>
            </tr>
            <tr>
                <td><label></label>Apellido paterno</td>
                <td><input type="text" name="a_paterno" title="Ingresa tu apellido paterno" required=""></td>
            </tr>
            <tr>
                <td><label>Apellido materno</label></td>
                <td><input type="text" name="a_materno" title="Ingresa tu apellido materno" required=""></td>
            </tr>
            <tr>
                <td><label>Correo electrónico</label></td>
                <td><input type="email" name="correo_e" placeholder="ejemplo@correo.com" title="Ingresa tu correo electrónico"required=""></td>
            </tr>
        </table>
        <input type="submit" name="crear" value="Crear">
    </form>
</body>
</html>