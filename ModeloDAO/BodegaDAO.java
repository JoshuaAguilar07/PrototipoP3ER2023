
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUDBodega;
import Modelo.Bodega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BodegaDAO implements CRUDBodega{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Bodega p=new Bodega();
    
    @Override
    public List listar() {
        ArrayList<Bodega>list=new ArrayList<>();
        String sql="select * from bodegas";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                Bodega per=new Bodega();
                
                per.setCodigo_bodega(rs.getString("codigo_bodega"));
                per.setNombre_bodega(rs.getString("nombre_bodega"));
                per.setEstatus_bodega(rs.getString("estatus_bodega"));
                //System.out.println(rs.getInt("Id"));
                list.add(per);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Bodega list(int id) {
        String sql="select * from bodegas where codigo_bodega="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setCodigo_bodega(rs.getString("codigo_bodega"));
                p.setNombre_bodega(rs.getString("nombre_bodega"));
                p.setEstatus_bodega(rs.getString("estatus_bodega"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Bodega b) {
       String sql="insert into bodegas(codigo_bodega, nombre_bodega, estatus_bodega)"
               + "values('"+b.getCodigo_bodega()+"','"+b.getNombre_bodega()+"','"+b.getEstatus_bodega()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Bodega b) {
        String sql="update bodegas set codigo_bodega='"+b.getCodigo_bodega()+"',nombre_bodega='"+b.getNombre_bodega()+"'where codigo_bodega="+b.getCodigo_bodega();
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
        String sql="delete from bodegas where codigo_bodega="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
