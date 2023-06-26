
<%@page import="Modelo.Vendedor"%>
<%@page import="ModeloDAO.VendedorDAO"%>
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
              VendedorDAO dao=new VendedorDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Vendedor p=(Vendedor)dao.list(id);
          %>
            <h1>Modificar Vendedor</h1>
            <form action="ControladorVendedor">
                <!--area-->
                  <form action="ControladorVendedor">
                    codigo:<br>
                    <input class="form-control" type="text" name="txtCodigo" value="<%= p.getCodigo_vendedor()%>"><br>
                    nombre: <br>
                    <input class="form-control" type="text" name="txtNom" value="<%= p.getNombre_vendedor()%>"><br>
                      direccion: <br>
                    <input class="form-control" type="text" name="txtDir" value="<%= p.getDireccion_vendedor()%>"><br>
                     telefono: <br>
                    <input class="form-control" type="text" name="tel" value="<%= p.getTelefono_vendedor()%>"><br>
 
                   <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    
                    <a href="ControladorVendedor?accion=listar">Regresar</a>
                </form>
        
                
              
                <a href="ControladorVendedor?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
