/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.dao.BillDAO;
import com.alfilsoft.model.Bill;
import com.alfilsoft.util.BOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.carvajal
 */
@Service
public class BillBOImpl implements BillBO {

    @Autowired
    private BillDAO billDAO;
    
    @Override
    public Bill save(Bill bill) throws BOException {
        return billDAO.save(bill);
    }
    
}
