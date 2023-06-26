
package Intefaces;

import Modelo.Bodega;
import java.util.List;


public interface CRUDBodega {
    
    public List listar();
    public Bodega list(int id);
    public boolean add(Bodega b);
    public boolean edit(Bodega b);
    public boolean eliminar(int id);
    
}
