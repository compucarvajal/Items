/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.dao.ItemDetailDAO;
import com.alfilsoft.model.ItemDetail;
import com.alfilsoft.util.BOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.carvajal
 */

@Service
public class ItemDetailBOImpl implements ItemDetailBO {

    @Autowired
    private ItemDetailDAO itemDetailDAO;

    @Override
    public List<ItemDetail> list(Long billId) throws BOException {
        return itemDetailDAO.list(billId);
    }

}
