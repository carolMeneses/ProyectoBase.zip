/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.services.impl.ServiciosAlquilerItemsImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISClienteDao;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISItemDAO;
import edu.eci.pdsw.samples.entities.Item;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class ServiciosAlquilerFactory {

    private static ServiciosAlquilerFactory instance = new ServiciosAlquilerFactory();
    
    private static Injector injector;
    
    private static Injector testInjector;
    
    private ServiciosAlquilerFactory(){
        
        injector = createInjector(new XMLMyBatisModule() {

                    @Override
                    protected void initialize() {
                        install(JdbcHelper.MySQL);                        
                        setClassPathResource("mybatis-config.xml");                        
                        bind(ServiciosAlquiler.class).to(ServiciosAlquilerItemsImpl.class);
                        bind(ItemDAO.class).to(MyBATISItemDAO.class);
                        bind(ClienteDAO.class).to(MyBATISClienteDao.class);
                    }

                }
                
        );

        testInjector = createInjector(new XMLMyBatisModule() {

                    @Override
                    protected void initialize() {
                        install(JdbcHelper.MySQL);                        
                        setClassPathResource("mybatis-config-h2.xml");                        
                        bind(ServiciosAlquiler.class).to(ServiciosAlquilerItemsImpl.class);
                        bind(ItemDAO.class).to(MyBATISItemDAO.class);
                        bind(ClienteDAO.class).to(MyBATISClienteDao.class);
                    }

                }
                
        );

        
    }

    public ServiciosAlquiler getServiciosAlquiler(){
        return injector.getInstance(ServiciosAlquiler.class);   
    }


    public ServiciosAlquiler getServiciosAlquilerTesting(){
        return testInjector.getInstance(ServiciosAlquiler.class);   
    }


    
    public static ServiciosAlquilerFactory getInstance(){
        return instance;
    }

    
    
}
