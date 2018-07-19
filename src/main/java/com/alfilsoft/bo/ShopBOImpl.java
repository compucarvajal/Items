/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.dao.ShopDAO;
import com.alfilsoft.model.Shop;
import com.alfilsoft.util.BOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.carvajal
 */
@Service
public class ShopBOImpl implements ShopBO {

    @Autowired
    private ShopDAO shopDAO;

    @Override
    public Shop search(Long id) throws BOException {
        try {
            return shopDAO.search(id);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Shop save(Shop shop) throws BOException {
        try {
            return shopDAO.save(shop);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Shop> search(String name) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
}
