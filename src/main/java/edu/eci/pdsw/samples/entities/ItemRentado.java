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
   
    private long id;
    private Item item;
    private Date fechainiciorenta;
    private int numdias;
    

    public ItemRentado(long id,Item item, Date fechainiciorenta, int numdias) {
        
        this.id = id;     
        this.item = item;
        this.fechainiciorenta = fechainiciorenta;
        this.numdias = numdias;
    }
    
    
    
    public ItemRentado() {
    }

     public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int numDias() {
        return numdias;
    }

    public void setNumDias(int numdias) {
        this.numdias = numdias;
    }
    public long tarifadia(){
     return getItem().getTarifaxDia();
    
    }
    public long getPrecioTotal(){
       
        return ((long) numdias)*tarifadia();
    }

      @Override
    public String toString() {
        return "ItemRentado{" + "id=" + id + ", item=" + item + ", fechainiciorenta=" + fechainiciorenta + ", numdias=" + numdias + '}';
    }

}
