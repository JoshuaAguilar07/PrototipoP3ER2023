
<%@page import="Modelo.Bodega"%>
<%@page import="ModeloDAO.BodegaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>bodegas</h1>
            <a class="btn btn-success" href="ControladorBodega?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Codigo</th>
                        <th class="text-center">Nombre Bodega</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    BodegaDAO dao=new BodegaDAO();
                    List<Bodega>list=dao.listar();
                    Iterator<Bodega>iter=list.iterator();
                    Bodega per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getCodigo_bodega()%></td>
                        <td class="text-center"><%= per.getNombre_bodega()%></td>
                        <td><%= per.getEstatus_bodega()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorBodega?accion=editar&id=<%= per.getCodigo_bodega()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorBodega?accion=eliminar&id=<%= per.getCodigo_bodega()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
