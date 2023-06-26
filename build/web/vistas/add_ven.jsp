
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
            <div class="col-lg-6">
                <h1>Agregar Vendedor</h1>
                <form action="ControladorVendedor">
                    codigo:<br>
                    <input class="form-control" type="text" name="txtCodigo" required><br>
                    nombre: <br>
                    <input class="form-control" type="text" name="txtNom" required><br>
                      direccion: <br>
                    <input class="form-control" type="text" name="txtDir"><br>
                     telefono: <br>
                    <input class="form-control" type="text" name="tel"><br>
 
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    
                    <a href="ControladorVendedor?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
