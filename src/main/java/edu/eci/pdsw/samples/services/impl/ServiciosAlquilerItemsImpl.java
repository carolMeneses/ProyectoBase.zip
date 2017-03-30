package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * 
 * @author hcadavid
 */
@Singleton
public class ServiciosAlquilerItemsImpl extends ServiciosAlquiler {
    
    private static final int MULTA_DIARIA=5000;
    @Inject
    private ItemDAO daoItem;
    @Inject
    private ItemRentadoDAO daoItemr;
    @Inject 
    private ClienteDAO daoCliente;
     @Inject 
    private TipoItemDAO daoTipoItem;
        
    @Override
    public int valorMultaRetrasoxDia() {
       return MULTA_DIARIA;
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
         try {
            return daoCliente.load(docu);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item "+docu,ex);
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        try {
            return daoCliente.loadItemRentado(idcliente);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar los items del cliente "+idcliente,ex);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return daoCliente.loadClientes();
        } catch (PersistenceException ex) {
                 throw new ExcepcionServiciosAlquiler("Error al consultar los  clientes ",ex);
        }
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return daoItem.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        List<Item> list= new ArrayList<>();
        return list;
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        return 0;
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return daoItem.load(id).getTipo();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el tipo item "+id,ex);
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       try{
       return daoTipoItem.load();
       } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el tipo item ",ex);
        }
       
        
    }

    @Override
    public void registrarAlquilerCliente(long docu,Item item,Date date,int numdias) throws ExcepcionServiciosAlquiler {
      
       ItemRentado nuevo=new ItemRentado(docu, item, date, numdias);
        try {
            daoItemr.save(nuevo);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al registrar item ",ex);
        }
       
       
        
    }

    @Override
    public void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler {
        
    }

    @Override
    public void registrarDevolucion(int iditem) throws ExcepcionServiciosAlquiler {
        
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        return 0;
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        
    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        
    }
    
    
    
}
