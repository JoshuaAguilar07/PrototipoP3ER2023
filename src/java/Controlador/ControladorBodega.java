
package Controlador;

import Modelo.Bodega;
import ModeloDAO.BodegaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorBodega extends HttpServlet {

    String listar="vistas/listar_bodega.jsp";
    String add="vistas/add_bodega.jsp";
    String edit="vistas/edit_bodega.jsp";
    Bodega p=new Bodega();
    BodegaDAO dao=new BodegaDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            System.out.println("entro");
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String codigo=request.getParameter("txtCodigo");
            String nom=request.getParameter("txtNom");
            String sts=request.getParameter("txtSts");
            p.setCodigo_bodega(codigo);
            p.setNombre_bodega(nom);
            p.setEstatus_bodega(sts);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String id = request.getParameter("txtCodigo");
            String dni=request.getParameter("txtNom");
            String nom=request.getParameter("txtSts");
            p.setCodigo_bodega(id);
            p.setNombre_bodega(dni);
            p.setEstatus_bodega(nom);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setCodigo_bodega(id+"");
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
