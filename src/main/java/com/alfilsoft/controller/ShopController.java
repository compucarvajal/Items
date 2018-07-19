/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.controller;

import com.alfilsoft.bo.ShopBO;
import com.alfilsoft.model.Item;
import com.alfilsoft.model.Shop;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis.carvajal
 */
@RestController
@RequestMapping("/Alfilsoft/Api/v1/Shop")
public class ShopController {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    @Autowired
    private ShopBO shopBO;

    @RequestMapping(value = "/search/{shopId}")
    public ResponseEntity<Shop> shopSearch(@PathVariable("shopId") String id) {
        LOGGER.info("------------------------>Begin of shopSearch method");
        try {
            return new ResponseEntity<>(shopBO.search(Long.valueOf(id)), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Shop shop) {
        LOGGER.info("------------------------>Begin of save shop method");
        try {
            shopBO.save(shop);
            return new ResponseEntity(HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/searchName/{name}")
    public ResponseEntity<List<Shop>> getShopSearch(@PathVariable("name") String name) {
        LOGGER.info("------------------------>Begin of getShopSearch by item name method");
        try {
            return new ResponseEntity<>(shopBO.search(name), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
