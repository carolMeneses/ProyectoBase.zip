/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.services.ServiciosAlquilerItemsStub;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clases Equivalencia
 * CE1: Todos los parametros deben estar compĺetos  p!=Null
 * CE2: El numero de documento y el telefono son strings, sin embargo,
 * no pueden tener numeros negativos.   Documento>0 && telefono]>0
 * 
 * 
 */
public class ClientesTest {

    public ClientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
  
    @Test
    public void additems1() throws ExcepcionServiciosAlquiler{
    	
    }
    
    @Test
    public void registroCliente() throws ExcepcionServiciosAlquiler{
        ServiciosAlquiler servicio=ServiciosAlquilerItemsStub.getInstance();
        servicio.registrarCliente(new Cliente("Paula Pinzon",1019108825,"123456","calle 167","paula@gmail.com"));
       
        assertEquals(1019108825,servicio.consultarCliente(1019108825).getDocumento());
        assertEquals("Paula Pinzon",servicio.consultarCliente(1019108825).getNombre());
        assertEquals("123456",servicio.consultarCliente(1019108825).getTelefono());
        assertEquals("calle 167",servicio.consultarCliente(1019108825).getDireccion());
        assertEquals("paula@gmail.com",servicio.consultarCliente(1019108825).getEmail());
          
    }
    
    @Test
    public void registroCliente2() throws ExcepcionServiciosAlquiler{
        ServiciosAlquiler servicio=ServiciosAlquilerItemsStub.getInstance();
        servicio.registrarCliente(new Cliente("Paula Pinzon",1019108825,"123456","calle 167","paula@gmail.com"));
        
        assertEquals(null,servicio.consultarCliente(1019108825).getDocumento());
        
    }
    
}
