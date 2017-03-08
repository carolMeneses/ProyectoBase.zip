/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2095957
 */
@ManagedBean(name = "cliente")
@SessionScoped
public class ClienteNuevo {

    String nombre;
    long documento;
    String telefono;
    String direccion;
    String email;
   
    Cliente ClienteNuevo;
    
    public ClienteNuevo(){
    nombre="";
    documento=0;
    telefono="";
    direccion="";
    email="";
   ClienteNuevo= new Cliente(nombre, documento, telefono, direccion, email);
   

}

    public void adicionarCliente() {
       ClienteNuevo= new Cliente(nombre, documento, telefono, direccion, email);

    }

    public String getNombre() {
        return ClienteNuevo.getNombre();
    }

   

    public void setNomb(String nomb) {
        this.nombre = nomb;
    }

    public long getDocumento() {
        return ClienteNuevo.getDocumento();
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return ClienteNuevo.getTelefono();
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return ClienteNuevo.getDireccion();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return ClienteNuevo.getEmail();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVetado() {
        return ClienteNuevo.isVetado();
    }

   

    public ArrayList<ItemRentado> getRentados() {
        return ClienteNuevo.getRentados();
    }


}
