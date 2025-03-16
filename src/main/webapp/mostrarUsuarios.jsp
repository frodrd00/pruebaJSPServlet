<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.demojavajsp.logica.Usuario" %>

<html>
<head>
    <title>Lista de usuarios</title>
</head>
<body>

<h1>Lista de Usuarios</h1>

<%
    List<Usuario> usuarioList = (List) request.getSession().getAttribute("listUsuarios");
    for (Usuario usuario : usuarioList) {
%>

<div id="user<%= usuario.getId() %>" style="display: flex; flex-direction: row;">

    <div>
        <p><strong>Id Usuario: <%= usuario.getId() %></strong></p>
        <p>DNI usuario: <%= usuario.getDni() %></p>
        <p>Nombre usuario: <u><%= usuario.getNombre() %></u></p>
        <p>Apellido usuario: <%= usuario.getApellido() %></p>
        <p>Telefono usuario: <%= usuario.getTelefono() %></p>

        <!-- Formulario para eliminar usuario -->
        <form action="SvDeleteUser" method="POST">
            <input type="hidden" name="_method" value="DELETE">
            <input type="hidden" name="userId" value="<%= usuario.getId() %>">
            <button type="submit">Eliminar usuario</button>
        </form>
    </div>

    <!-- Formulario para actualizar usuario -->
    <form action="SvUpdateUser" method="POST">
        <input type="hidden" name="userId" value="<%= usuario.getId() %>">

        <!-- Campo de nombre -->
        <label for="nombre<%= usuario.getId() %>">Nombre:</label>
        <input type="text" id="nombre<%= usuario.getId() %>" name="nombre" value="<%= usuario.getNombre() %>" required><br><br>

        <!-- Campo de apellido -->
        <label for="apellido<%= usuario.getId() %>">Apellido:</label>
        <input type="text" id="apellido<%= usuario.getId() %>" name="apellido" value="<%= usuario.getApellido() %>" required><br><br>

        <!-- Campo de teléfono -->
        <label for="telefono<%= usuario.getId() %>">Teléfono:</label>
        <input type="text" id="telefono<%= usuario.getId() %>" name="telefono" value="<%= usuario.getTelefono() %>" required><br><br>

        <button type="submit">Actualizar usuario</button>
    </form>

</div>

<% } %>

</body>
</html>
