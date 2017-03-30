/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.util.List;

/**
 *
 * @author 3070465
 */
public class MyBATISClienteDao  implements ClienteDAO{
    @Inject
    private ClienteMapper cm;
    @Inject
    private ItemRentadoMapper ir;
    
    
    @Override
    public void save(Cliente c) throws PersistenceException {
        try{
            cm.insertarCliente(c);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el cliente "+c.toString(),e);
        }      
        
    }
  

   @Override
   public Cliente load(long id) throws PersistenceException {
        try{
            return cm.getCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente "+id,e);
        }
        
    }
   @Override
   public List<ItemRentado> loadItemRentado(long id ) throws PersistenceException {
       try{
           return cm.getItemsRentados(id);
       }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente "+id,e);
        }
   }

    @Override
    public List<Cliente> loadClientes() throws PersistenceException {
        try{
            return cm.getClientes();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los clientes ",e);
        }
    }

  
}
        
        
