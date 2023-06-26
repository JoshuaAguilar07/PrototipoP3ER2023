
<%@page import="Modelo.Vendedor"%>
<%@page import="ModeloDAO.VendedorDAO"%>
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
        <title>Vendedores</title>
    </head>
    <body>
        <div class="container">
            <h1>Vendedores</h1>
            <a class="btn btn-success" href="ControladorVendedor?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Codigo</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Direccion</th>
                          <th class="text-center">Telefono</th>
                            <th class="text-center">Nit</th>
                             <th class="text-center">Estado</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    VendedorDAO dao=new VendedorDAO();
                    List<Vendedor>list=dao.listar();
                    Iterator<Vendedor>iter=list.iterator();
                    Vendedor per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getCodigo_vendedor()%></td>
                        <td class="text-center"><%= per.getNombre_vendedor()%></td>
                        <td><%= per.getDireccion_vendedor()%></td>
                        <td><%= per.getTelefono_vendedor()%></td>
                        <td><%= per.getNit_vendedo()%></td>
                        <td><%= per.getEstatus_vendedor()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorVendedor?accion=editar&id=<%= per.getCodigo_vendedor()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorVendedor?accion=eliminar&id=<%= per.getCodigo_vendedor()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
