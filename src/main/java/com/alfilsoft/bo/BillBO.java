/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.model.Bill;
import com.alfilsoft.util.BOException;
import java.util.List;

/**
 *
 * @author luis.carvajal
 */
public interface BillBO {

    public Bill save(Bill bill) throws BOException;

    public List<Bill> list(Long shopId) throws BOException;

    public Boolean sendEmail(Long shopId, Long billId) throws BOException;

}
