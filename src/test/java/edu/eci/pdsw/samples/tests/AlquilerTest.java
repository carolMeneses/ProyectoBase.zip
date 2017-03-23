/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerItemsStub;
import java.sql.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * 
 * Calculo Multa:
 * 
 * Frontera:
 * CF1: Multas a devoluciones hechas en la fecha exacta (multa 0).
 * 
 * Clases de equivalencia:
 * CE1: Multas hechas a devolciones realizadas en fechas posteriores
 * a la limite. (multa multa_diaria*dias_retraso)
 * 
 * 
 * 
 */
public class AlquilerTest {

    public AlquilerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    /**
    *No debería cobrar multa cuando se entrega la pelicula en el día limite
    */
    @Test
    public void CF1Test() throws ExcepcionServiciosAlquiler{
        ServiciosAlquiler sa=ServiciosAlquilerItemsStub.getInstance();
        
        Item i1=new Item(sa.consultarTipoItem(1), 44, "Los 4 Fantasticos", "Los 4 Fantásticos  es "
                + "una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");        
        sa.registrarCliente(new Cliente("Juan Perez",3842,"24234","calle 123","aa@gmail.com"));
        sa.registrarItem(i1);
                
        Item item=sa.consultarItem(44);
        
        sa.registrarAlquilerCliente(java.sql.Date.valueOf("2005-12-20"), 3842, item, 5);
        
        assertEquals("No se calcula correctamente la multa (0) "
                + "cuando la devolucion se realiza el dia limite."
                ,0,sa.consultarMultaAlquiler(44, java.sql.Date.valueOf("2005-12-25")));
                
    }
    
    /**
    *Debería cobrar la multa por 3 días de trabajo
    */
    @Test
    public void CE1Test() throws ExcepcionServiciosAlquiler{
        ServiciosAlquiler sa=ServiciosAlquilerItemsStub.getInstance();
        
        Item i1=new Item(sa.consultarTipoItem(1), 55, "Los 4 Fantasticos", "Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");        
        sa.registrarCliente(new Cliente("Juan Perez",9843,"24234","calle 123","aa@gmail.com"));
        sa.registrarItem(i1);
                
        Item item=sa.consultarItem(55);
        
        sa.registrarAlquilerCliente(java.sql.Date.valueOf("2005-12-20"), 9843, item, 5);
        //prueba: 3 dias de retraso
        assertEquals("No se calcula correctamente la multa "
                + "cuando la devolucion se realiza varios dias despues del limite."
                ,sa.valorMultaRetrasoxDia()*3,sa.consultarMultaAlquiler(55, java.sql.Date.valueOf("2005-12-28")));
                
    }
    /**
     * La fecha de devolución debe ser mayor o igual a la fecha de alquiler
     */
    @Test
    public void CE2Test() throws ExcepcionServiciosAlquiler{
        ServiciosAlquiler sa=ServiciosAlquilerItemsStub.getInstance();
                                
        Item i1=new Item(sa.consultarTipoItem(1), 55, "Los 5 Fantasticos", "Los 5 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");        
        sa.registrarCliente(new Cliente("Juanito Perez",9269,"24234","calle 123","aaa@gmail.com"));
        sa.registrarItem(i1);
                
        Item item=sa.consultarItem(55);
        
        sa.registrarAlquilerCliente(java.sql.Date.valueOf("2005-12-20"), 9269, item, 5);
        List<ItemRentado> ir= null;
        ir=sa.consultarItemsCliente(9843);
        Date devolucion=java.sql.Date.valueOf("2005-12-22");
        int fecha=ir.get(0).getFechainiciorenta().compareTo(devolucion); //
        assertTrue(fecha<0);
    }

    /**
     * El costo del alquiler no puede ser mayor al costo de multa diaria
     */
     /**
     * El costo del alquiler no puede ser mayor al costo de multa diaria
     */
     /**
     * La tarifa de alquiler debe ser mayor a 0
     */ /**
     * Debe permitir modificar la tarifa
     */
    
}
