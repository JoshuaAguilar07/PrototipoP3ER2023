
package Modelo;


public class Bodega {
    
    String codigo_bodega;
    String nombre_bodega;
    String estatus_bodega;

    public Bodega() {
    }

    
    public Bodega(String codigo_bodega, String nombre_bodega, String estatus_bodega) {
        this.codigo_bodega = codigo_bodega;
        this.nombre_bodega = nombre_bodega;
        this.estatus_bodega = estatus_bodega;
    }

    public String getCodigo_bodega() {
        return codigo_bodega;
    }

    public void setCodigo_bodega(String codigo_bodega) {
        this.codigo_bodega = codigo_bodega;
    }

    public String getNombre_bodega() {
        return nombre_bodega;
    }

    public void setNombre_bodega(String nombre_bodega) {
        this.nombre_bodega = nombre_bodega;
    }

    public String getEstatus_bodega() {
        return estatus_bodega;
    }

    public void setEstatus_bodega(String estatus_bodega) {
        this.estatus_bodega = estatus_bodega;
    }
    
    
    
}
