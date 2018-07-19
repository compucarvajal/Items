/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.dao.ItemDAO;
import com.alfilsoft.dao.ShopDAO;
import com.alfilsoft.model.Item;
import com.alfilsoft.model.Shop;
import com.alfilsoft.util.BOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.carvajal
 */
@Service
public class ItemBOImpl implements ItemBO {

    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private ShopDAO shopDAO;

    @Override
    public List<Item> list(Long shopId) throws BOException {
        try {
            return itemDAO.list(shopId);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Item search(Long id) throws BOException {
        try {
            return itemDAO.search(id);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Item> search(String name) throws BOException {

        try {
            return itemDAO.search(name);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Item save(Item item) throws BOException {
        try {
            return itemDAO.save(item);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Item save(Item item, Long shopId) throws BOException {
        try {
            //Shop temp = shopDAO.search(shopId);
            //item.setShop(temp);
            return itemDAO.save(item);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }
//

    @Override
    public List<Item> save(List<Item> items) throws BOException {
        try {
            List<Item> itemsList = new ArrayList<>();
            items.stream().map((item) -> {
                //search the shop with id provided
                item.setShop(null);
                return item;
            }).forEachOrdered((item) -> {
                itemsList.add(itemDAO.save(item));
            });
            return itemsList;
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Item> save(List<Item> items, Long shopId) throws BOException {
        try {
            List<Item> itemsList = new ArrayList<>();
            items.stream().map((item) -> {
                //search the shop with id provided
                item.setShop(null);
                return item;
            }).forEachOrdered((item) -> {
                itemsList.add(itemDAO.save(item));
            });
            return itemsList;
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Item> list(Map<String, String> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> search(String name, Long shopId) throws BOException {
        try {
            return itemDAO.search(name,shopId);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

}
