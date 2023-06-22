<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/22/2023
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Agregar Vendedor</title>
</head>
<body>
<h1 class="encabezado"> Agregar Vendedor</h1>
<form action="agregarLibro" method="post">
    <div class="centrado">
        <label> Nombre: </label>
        <input name="nombre" type="text" class="campoTexto">

        <label> RUT: </label>
        <input name="rut" type="text" class="campoTexto">

        <label> Direccion: </label>
        <input name="direccion" type="text" class="campoTexto">

        <label> Titulo Profesional: </label>
        <input name="titulo_profesional" type="text" class="campoTexto">

        <label> Estado Civil: </label>
        <select name="estado_civil">
            <optgroup label="Seleccionar"></optgroup>
            <option>Soltero</option>
            <option>Casado</option>
            <option>Viudo</option>
        </select>

        <br><br>
        <input type="submit" value="Registrar" class="boton">
        <a class="boton" href="index.jsp">Volver</a>
    </div>
</form>
</body>
</html>
