/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.dao;

import com.alfilsoft.model.Category;
import com.alfilsoft.model.Item;
import com.alfilsoft.model.Shop;
import com.alfilsoft.util.DAOException;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luis.carvajal
 */
public class ItemDAOTest {
    
    
    @Autowired
    private ItemDAO itemDAO;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    @Before
    public void setUp() throws Exception {
        Item item= new Item();
        item.setCreationDate(new Date());
        item.setId(1L);
        item.setName("test");
        //itemDAO.save(item);
        
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of save method, of class ItemDAO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Item item = new Item(1L, new Category("name", "code", "description"), 
                new Shop(new Date(), "12345", "Pepe perez", "Tienda", "Nit", "Natural"), new Date(), "name", 20.0);
       
   
//        Item result = itemDAO.save(item);
//        Assert.assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    
}
