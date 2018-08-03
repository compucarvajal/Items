/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.model.ItemDetail;
import com.alfilsoft.util.BOException;
import java.util.List;

/**
 *
 * @author luis.carvajal
 */
public interface ItemDetailBO {
    
    List<ItemDetail> list(Long billId)throws BOException;
    
}
