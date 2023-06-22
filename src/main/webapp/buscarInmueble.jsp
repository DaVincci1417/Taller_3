<%@ page import="java.sql.*" %>
<%@ page import="com.example.taller_3.Model.Data.DBGenerator" %><%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/22/2023
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostrar usuarios</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<%
    DBGenerator.iniciarBD("TiendaInmueble");
    Connection con;
    String Driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String clave = "";
    Class.forName(Driver);
    con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/TiendaInmueble",user,clave);
    PreparedStatement prepared;
    ResultSet resultSet;
    prepared = con.prepareStatement("select * from inmueble");
    resultSet = prepared.executeQuery();
%>
<div class="centrado">
    <h1 class="encabezado">Articulos de la Tienda</h1>
    <br><br>
    <div class="campoTexto centrado">
        <form>
            <input type="text" name="buscarUbicacionGeo">
            <br>
            <input type="submit" value="Buscar">
        </form>
        <%
            String ubicacionBuscar = request.getParameter("buscarUbicacionGeo");
            if(ubicacionBuscar!=null){
                resultSet = prepared.executeQuery("select * from inmueble where ubicacion_geografica LIKE"+"'%"+ubicacionBuscar+"%'");
            }else{
            }
        %>
    </div>
    <br><br>
    <table class="table">
        <tr>
            <th class="th centrado">Tipo de Construccion</th>
            <th class="th centrado">Ubicacion Geografica</th>
            <th class="th centrado">Precio</th>
        </tr>
        <%
            while(resultSet.next()){
        %>
        <tr>
            <td class="td centrado"><%= resultSet.getString("tipo_construccion")%></td>
            <td class="td centrado"><%= resultSet.getString("ubicacion_geografica")%> </td>
            <td class="td centrado"><%= resultSet.getInt("precio")%></td>
        </tr>
        <%}%>
    </table>
    <br><br>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>