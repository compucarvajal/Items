/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.controller;

import com.alfilsoft.bo.ItemDetailBO;
import com.alfilsoft.model.Item;
import com.alfilsoft.model.ItemDetail;
import com.alfilsoft.util.BOException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis.carvajal
 */
@RestController
@RequestMapping("/Alfilsoft/Api/v1/ItemDetail")
public class ItemDetailController {
    
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    
    @Autowired
    private ItemDetailBO itemDetailBO;
    
    @RequestMapping(value = "/details/{billId}")
    public ResponseEntity<List<ItemDetail>> getBills(@PathVariable(value = "billId") String shopId) {
        LOGGER.info("------------------------>Begin of getBills method");
        try {
            List<ItemDetail> items = itemDetailBO.list(Long.valueOf(shopId));
//            bills.stream().map((bill) -> {
//                bill.setItemDetailList(null);
//                return bill;
//            }).forEachOrdered((bill) -> {
//                bill.getShop().setBillList(null);
//            });
            items.stream().map((item) -> {
                item.setBill(null);
                return item;
            }).forEachOrdered((item) -> {
                item.getItem().setShop(null);
            });
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
