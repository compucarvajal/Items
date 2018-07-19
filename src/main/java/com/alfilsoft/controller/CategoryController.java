/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.controller;

import com.alfilsoft.bo.CategoryBO;
import com.alfilsoft.model.Category;
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
@RequestMapping("/Alfilsoft/Api/v1/Category")
public class CategoryController {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    @Autowired
    private CategoryBO categoryBO;

    @RequestMapping(value = "/categories")
    public ResponseEntity<List<Category>> getCategories() {
        LOGGER.info("------------------------>Begin of getCategories method");
        try {
            return new ResponseEntity<>(categoryBO.list(), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/categories/{shopId}")
    public ResponseEntity<List<Category>> getCategoriesShop(@PathVariable("shopId") Long shopId) {
        try {
            LOGGER.info("------------------------>Begin of getCategoriesShop method");
            return new ResponseEntity<>(categoryBO.list(shopId), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Category category) {
        try {
            LOGGER.info("------------------------>Begin of save category method");
            return new ResponseEntity<>(categoryBO.save(category), HttpStatus.OK);
        } catch (BOException ex) {
            LOGGER.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
