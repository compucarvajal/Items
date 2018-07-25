/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.dao;

import com.alfilsoft.model.Item;
import com.alfilsoft.model.Shop;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luis.carvajal
 */
public interface ShopDAO extends CrudRepository<Shop, Long> {
    
    
    @Override
    public Shop save(Shop shop);
    
    @Query("select c from Shop c where c.id =?1")
    public Shop search(Long idShop);
    
    @Query("select c from Shop c where c.shortName = ?1")
    public List<Shop> search(String name);
    
    
    
}
