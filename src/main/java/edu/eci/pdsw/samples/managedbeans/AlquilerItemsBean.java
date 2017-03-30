/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @Meneses-Pinzon
 */
//@ManagedBean(name = "AlquilerItems")
@SessionScoped
public class AlquilerItemsBean implements Serializable {

    String nombre ;
    long documento;
    String telefono;
    String direccion;
    String email;
    long totalAlquiler;
    Cliente ClienteNuevo;
    ItemRentado nuevaRenta;
    List<Item> itemC;
    List<ItemRentado> items;    
    int id;
    ServiciosAlquiler sp;
    Item i;
    int numdias;
    Date date;
    Date fin;
    
    public AlquilerItemsBean() {
        this.sp = ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();
        nombre = "";
        documento = 0;
        telefono = "";
        direccion = "";
        email = "";
        id=0;
        ClienteNuevo = new Cliente(nombre, documento, telefono, direccion, email);
        itemC=sp.consultarItemsDisponibles();
        i=itemC.get(0);
        numdias=0;
        date=new java.util.Date(); 
        totalAlquiler=0;
    }

    public long getTotalAlquiler() {
        return totalAlquiler;
    }
    public void setTotalAlquiler() {
        totalAlquiler=sp.valorMultaRetrasoxDia()*numdias;
    }
   

    public void adicionarCliente() throws ExcepcionServiciosAlquiler {
       
        ClienteNuevo = new Cliente(nombre, documento, telefono, direccion, email);
        sp.registrarCliente(ClienteNuevo);
    }
    
    public void adicionarAlquiler() throws ExcepcionServiciosAlquiler {
         
         i=sp.consultarItem(id);
         setTotalAlquiler();
        System.out.println(numdias);
        
        sp.registrarAlquilerCliente(documento, i, (java.sql.Date) date, numdias);
       
        System.out.println(documento);
        System.out.println(i);
        System.out.println(numdias);
        System.out.println(totalAlquiler);
        
        
        
        
        
    }

    public Item getI() {
        return i;
    }

    public void setI(Item i) {
        this.i = i;
    }

    public int getNumDias() {
        return numdias;
    }

    public void setNumDias(int numDias) {
        this.numdias = numDias;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<ItemRentado> getItems() throws ExcepcionServiciosAlquiler {
        items=sp.consultarItemsCliente(getDocumento());
        //System.out.println(items);
        return items;
        
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getClienteNuevo() {
        return ClienteNuevo;
    }

    public void setClienteNuevo(Cliente ClienteNuevo) {
        this.ClienteNuevo = ClienteNuevo;
    }
    
    public ServiciosAlquiler getSp() {
        return sp;
    }

    public void setSp(ServiciosAlquiler sp) {
        this.sp = sp;
    }
    
    
     public List<Cliente> getClientesExistentes() throws ExcepcionServiciosAlquiler {
        return sp.consultarClientes();
    }
    
}
