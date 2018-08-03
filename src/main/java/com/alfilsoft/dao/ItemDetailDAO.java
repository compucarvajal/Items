/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.dao;

import com.alfilsoft.model.Bill;
import com.alfilsoft.model.ItemDetail;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luis.carvajal
 */
public interface ItemDetailDAO extends CrudRepository<ItemDetail, Long> {

    @Query("select b from ItemDetail b where b.bill.id =?1")
    public List<ItemDetail> list(Long billId);

}
