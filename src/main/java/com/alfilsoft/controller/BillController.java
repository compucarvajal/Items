/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.controller;

import com.alfilsoft.bo.BillBO;
import com.alfilsoft.model.Bill;
import com.alfilsoft.util.BOException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis.carvajal
 */
@RestController
@RequestMapping("/Alfilsoft/Api/v1/Bill")
public class BillController {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    @Autowired
    private BillBO billBO;

    @RequestMapping(value = "/saveBill", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Bill bill) {
        LOGGER.info("------------------------>Begin of save whit bill method");
        try {
            billBO.save(bill);
            return new ResponseEntity(HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/bills/{shopId}")
    public ResponseEntity<List<Bill>> getBills(@PathVariable(value = "shopId") String shopId) {
        LOGGER.info("------------------------>Begin of getBills method");
        try {
            List<Bill> bills = billBO.list(Long.valueOf(shopId));
            bills.stream().map((bill) -> {
                bill.setItemDetailList(null);
                return bill;
            }).forEachOrdered((bill) -> {
                bill.getShop().setBillList(null);
            });
            return new ResponseEntity<>(bills, HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
