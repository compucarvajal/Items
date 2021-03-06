/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.dao;

import com.alfilsoft.model.Bill;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luis.carvajal
 */
public interface BillDAO extends CrudRepository<Bill, Long> {

    @Override
    public Bill save(Bill bill);

    @Query("select b from Bill b where b.shop.id =?1")
    public List<Bill> list(Long idShop);

    @Query("select b from Bill b where b.shop.id =?1 and b.id=?2")
    public Bill search(Long shopId, Long billId);

}
