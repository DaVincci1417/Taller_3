<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/22/2023
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title></title>
</head>
<body>
<h1 class="encabezado">
    Tienda de Inmuebles
</h1>
<h2 class="subtitulo">
    Se ha agregado con exito el Inmueble
</h2>
<table>
    <form action="agregarVendedor.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Vendedor" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="agregarInmueble.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Inmueble" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="buscarInmueble.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Buscar Inmueble" class="boton">
        </div>
    </form>
</table>
</body>
</html>