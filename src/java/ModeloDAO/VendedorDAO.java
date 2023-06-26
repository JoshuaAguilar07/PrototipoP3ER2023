
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUDVendedor;
import Modelo.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO implements CRUDVendedor{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vendedor p=new Vendedor();
    
    @Override
    public List listar() {
        ArrayList<Vendedor>list=new ArrayList<>();
        String sql="select * from vendedores";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                Vendedor per=new Vendedor();
                
                per.setCodigo_vendedor(rs.getString("codigo_vendedor"));
                per.setNombre_vendedor(rs.getString("nombre_vendedor"));
                per.setDireccion_vendedor(rs.getString("direccion_vendedor"));
                per.setTelefono_vendedor(rs.getString("telefono_vendedor"));
                per.setNit_vendedo(rs.getString("nit_vendedor"));
                per.setEstatus_vendedor(rs.getString("estatus_vendedor"));
        
                //System.out.println(rs.getInt("I"));
                list.add(per);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Vendedor list(int id) {
        String sql="select * from vendedores where codigo_vendedor="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){         
                
                  p.setCodigo_vendedor(rs.getString("codigo_vendedor"));
                p.setNombre_vendedor(rs.getString("nombre_vendedor"));
                p.setDireccion_vendedor(rs.getString("direccion_vendedor"));
                p.setTelefono_vendedor(rs.getString("telefono_vendedor"));
                p.setNit_vendedo(rs.getString("nit_vendedor"));
                p.setEstatus_vendedor(rs.getString("estatus_vendedor"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Vendedor b) {
       String sql="insert into vendedores(codigo_vendedor, nombre_vendedor, direccion_vendedor, telefono_vendedor, nit_vendedor, estatus_vendedor)"
               + " values('"+b.getCodigo_vendedor()+"','"+b.getNombre_vendedor()+"','"+b.getDireccion_vendedor()+"','"+b.getTelefono_vendedor()+"','"+b.getNit_vendedo()+"','"+b.getEstatus_vendedor()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.print(e.getMessage());
        }
       return false;
    }

    @Override
    public boolean edit(Vendedor b) {
        String sql="update vendedores set nombre_vendedor='"+b.getNombre_vendedor()+"',direccion_vendedor='"+b.getDireccion_vendedor()+",telefono_vendedor='"+b.getTelefono_vendedor()+" where codigo_vendedor="+b.getCodigo_vendedor();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from vendedores where codigo_vendedor="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
