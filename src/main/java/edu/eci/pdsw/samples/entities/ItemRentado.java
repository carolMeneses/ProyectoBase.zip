/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import static javax.swing.text.html.HTML.Tag.SELECT;

/**
 *
 * @author 2106913
 */
public class ItemRentado implements Serializable{
    
    private Item item;
    private Date fechainiciorenta;
    private Date fechafinrenta;
    

    public ItemRentado(Item item, Date fechainiciorenta, Date fechafinrenta) {
              
        this.item = item;
        this.fechainiciorenta = fechainiciorenta;
        this.fechafinrenta = fechafinrenta;
    }
    
    
    
    public ItemRentado() {
    }

    
    public Item getItem() {
        return item;
    }
    
    
    public void setItem(Item item) {
        this.item = item;
    }

    public Date getFechainiciorenta() {
        return fechainiciorenta;
    }

    public void setFechainiciorenta(Date fechainiciorenta) {
        this.fechainiciorenta = fechainiciorenta;
    }

    public Date getFechafinrenta() {
        return fechafinrenta;
    }

    public void setFechafinrenta(Date fechafinrenta) {
        this.fechafinrenta = fechafinrenta;
    }
    public long tarifadia(){
     return getItem().getTarifaxDia();
    
    }
    public long getPrecioTotal(){
        long fechaInicialMs = getFechainiciorenta().getTime();
        long fechaFinalMs = getFechafinrenta().getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((long) dias)*tarifadia();
    }

   

}