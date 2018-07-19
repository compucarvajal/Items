/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.model.Shop;
import com.alfilsoft.util.BOException;
import java.util.List;

/**
 *
 * @author luis.carvajal
 */
public interface ShopBO {

    public Shop search(Long id) throws BOException;

    public Shop save(Shop shop) throws BOException;
    
    public List<Shop> search(String name)throws BOException;

}
