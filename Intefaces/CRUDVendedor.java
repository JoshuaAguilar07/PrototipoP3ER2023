/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces;

import Modelo.Vendedor;
import java.util.List;

/**
 *
 * @author niels
 */
public interface CRUDVendedor {
    
      public List listar();
    public Vendedor list(int id);
    public boolean add(Vendedor v);
    public boolean edit(Vendedor v);
    public boolean eliminar(int id);
    
    
}
