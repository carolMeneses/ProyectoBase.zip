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
import edu.eci.pdsw.samples.services.ServiciosAlquilerItemsStub;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "AlquilerItems")
@SessionScoped
public class AlquilerItemsBean implements Serializable {

    String nombre ;
    long documento;
    String telefono;
    String direccion;
    String email;
    int multa;
    Cliente ClienteNuevo;
    List<ItemRentado> items;    
    ServiciosAlquiler sp = ServiciosAlquiler.getInstance();

    public AlquilerItemsBean() {
        nombre = "";
        documento = 0;
        telefono = "";
        direccion = "";
        email = "";
        ClienteNuevo = new Cliente(nombre, documento, telefono, direccion, email);

    }

    public void adicionarCliente() throws ExcepcionServiciosAlquiler {
        ClienteNuevo = new Cliente(nombre, documento, telefono, direccion, email);
        sp.registrarCliente(ClienteNuevo);
    }
    
    public void adicionarAlquiler() throws ExcepcionServiciosAlquiler {
        ClienteNuevo = new Cliente(nombre, documento, telefono, direccion, email);
        sp.registrarCliente(ClienteNuevo);
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
    public void getMulta(){
    /**
     * Pendiente
     */
    
    }
    
     public List<Cliente> getClientesExistentes() throws ExcepcionServiciosAlquiler {
        return sp.consultarClientes();
    }
    
}
