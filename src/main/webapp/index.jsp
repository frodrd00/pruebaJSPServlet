<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario de Prueba</title>
</head>
<body>
<h1>Datos del cliente</h1>
<form action="SvUsuarios" method="POST">
    <p><label>Dni: </label> <input type="text" name="dni"></p>
    <p><label>Nombre: </label> <input type="text" name="nombre"></p>
    <p><label>Apellido: </label> <input type="text" name="apellido"></p>
    <p><label>Teléfono: </label> <input type="text" name="telefono"></p>
    <button type="submit">Enviar</button>
</form>

<h1>Ver lista de usuarios</h1>
<form action="SvUsuarios" method="GET">
    <button type="submit">Ver lista de usuarios</button>
</form>

</body>
</html>
