
<%@page import="ModeloDAO.BodegaDAO"%>
<%@page import="Modelo.Bodega"%>
<%@page import="Modelo.Persona"%>
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
            <div class="col-lg-6">
              <%
              BodegaDAO dao=new BodegaDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Bodega p=(Bodega)dao.list(id);
          %>
            <h1>Modificar Bodega</h1>
            <form action="ControladorBodega">
                Codigo:<br>
                <input class="form-control" type="text" name="txtCodigo" value="<%= p.getCodigo_bodega()%>"><br>
                Nombre: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getNombre_bodega()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= p.getCodigo_bodega()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorBodega?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
