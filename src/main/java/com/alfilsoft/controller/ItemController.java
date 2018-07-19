/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.controller;

import com.alfilsoft.bo.ItemBO;
import com.alfilsoft.model.Item;
import com.alfilsoft.util.BOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author luis.carvajal
 */
@RestController
@RequestMapping("/Alfilsoft/Api/v1/Item")
public class ItemController {

    @Value("${item.controller}")
    private static String ITEM_CONTROLLER;

//    private static final Logger LOGGER = Logger.getLogger(ITEM_CONTROLLER);
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    
    
    @Autowired
    private ItemBO itemBO;

    @RequestMapping(value = "/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable String itemId) {
        LOGGER.info("------------------------>Begin of getItem method");
        try {
            return new ResponseEntity<>(itemBO.search(Long.valueOf(itemId)), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/items")
    public ResponseEntity<List<Item>> getItems(@RequestParam(value = "shopId") String shopId) {
        LOGGER.info("------------------------>Begin of getItems method");
        try {
            return new ResponseEntity<>(itemBO.list(Long.valueOf(shopId)), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search")
    public ResponseEntity<List<Item>> getItemSearch(@RequestParam(value = "name") String name) {
        LOGGER.info("------------------------>Begin of getItemSearch method");
        try {
            return new ResponseEntity<>(itemBO.search(name), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/searchShop")
    public ResponseEntity<List<Item>> getItemSearchShop(@RequestParam(value = "name") String name, @RequestParam(value = "shopId") String shopId) {
        LOGGER.info("------------------------>Begin of getItemSearchShop method");
        try {
            return new ResponseEntity<>(itemBO.search(name), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Item item) {
        LOGGER.info("------------------------>Begin of save whit shop method");
        try {
            itemBO.save(item);
            return new ResponseEntity(HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveItems/{shopId}", method = RequestMethod.POST)
    public ResponseEntity saveItems(@PathVariable("shopId") Long shopId, @RequestBody List<Item> items) {
        LOGGER.info("------------------------>Begin of save method");
        try {
            itemBO.save(items, shopId);
            return new ResponseEntity(HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/search/{shopId}")
    public ResponseEntity<List<Item>> getItemSearch(@PathVariable("shopId") Long shopId, @RequestParam(value = "name") String name) {
        LOGGER.info("------------------------>Begin of getItemSearch by item name method");
        try {
            return new ResponseEntity<>(itemBO.search(name,shopId), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
