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
    <title>Agregar Inmueble</title>
</head>
<body>
<h1 class="encabezado"> Agregar Inmueble</h1>
<form action="agregarInmueble" method="post">
    <div class="centrado">
        <label> Tipo de Contruccion: </label>
        <select name="tipo_construccion">
            <optgroup label="Seleccionar"></optgroup>
            <option>Madera</option>
            <option>Cemento</option>
            <option>Hormigon</option>
            <option>Ladrillo</option>
            <option>Barro y arcilla</option>
        </select>

        <label> Ubicacion Geografica: </label>
        <input name="ubicacion_geografica" type="text" class="campoTexto">

        <label> Precio: </label>
        <input name="precio" type="number" class="campoTexto">

        <br><br>
        <input type="submit" value="Agregar" class="boton">
        <a class="boton" href="index.jsp">Volver</a>
    </div>
</form>
</body>
</html>
