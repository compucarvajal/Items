/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.dao;

import com.alfilsoft.model.Category;
import com.alfilsoft.model.Item;
import com.alfilsoft.util.DAOException;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luis.carvajal
 */
public interface ItemDAO extends CrudRepository<Item, Long> {

    @Override
    public Item save(Item item);

    @Query("select c from Item c where c.shop.id =?1")
    public List<Item> list(Long idShop);
    
    @Query("select c from Item c where c.id =?1")
    public Item search(Long idItem);
    
    @Query("select c from Item c where c.name Like %?1%")
    public List<Item> search(String name);
    
    @Query("select c from Item c where c.name Like %?1% and c.shop.id =?2")
    public List<Item> search(String name, Long shopId );
    
    

}
