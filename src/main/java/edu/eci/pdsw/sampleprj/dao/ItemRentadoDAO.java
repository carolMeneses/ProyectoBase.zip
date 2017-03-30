/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.util.List;

/**
 *
 * @author 2095957
 */
public interface ItemRentadoDAO {

    public void save(ItemRentado it) throws PersistenceException;

    public ItemRentado load(int id) throws PersistenceException;
    
    

}