
package Controlador;

import Modelo.Vendedor;
import ModeloDAO.VendedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorVendedor extends HttpServlet {

    String listar="vistas/listar_ven.jsp";
    String add="vistas/add_ven.jsp";
    String edit="vistas/edit_ven.jsp";
    Vendedor p=new Vendedor();
    VendedorDAO dao=new VendedorDAO();
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
            String dir=request.getParameter("txtDir");
            String tel=request.getParameter("tel");
            p.setCodigo_vendedor(codigo);
            p.setNombre_vendedor(nom);
            p.setDireccion_vendedor(dir);
            p.setTelefono_vendedor(tel);
            p.setNit_vendedo("0");
            p.setEstatus_vendedor("0");
            
            dao.add(p);
            System.out.println("agregando2");
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            
           String codigo=request.getParameter("txtCodigo");
            String nom=request.getParameter("txtNom");
            String dir=request.getParameter("txtDir");
            String tel=request.getParameter("tel");
            p.setCodigo_vendedor(codigo);
            p.setNombre_vendedor(nom);
            p.setDireccion_vendedor(dir);
             p.setTelefono_vendedor(tel);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            //p.setCodigo_vendedor(request.getParameter("id"));
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
