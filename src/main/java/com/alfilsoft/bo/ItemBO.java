/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.model.Item;
import com.alfilsoft.util.BOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luis.carvajal
 */
public interface ItemBO {

    public List<Item> list(Long shopId) throws BOException;

    public Item search(Long id) throws BOException;

    public List<Item> search(String name) throws BOException;
    
    public List<Item> search(String name, Long shopId) throws BOException;

    public Item save(Item item) throws BOException;

    public Item save(Item item, Long shopId) throws BOException;

    public List<Item> save(List<Item> items) throws BOException;
    
    public List<Item> save(List<Item> items, Long shopId) throws BOException;

    public List<Item> list(Map<String, String> filters);

}
