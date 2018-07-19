/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.dao;

import com.alfilsoft.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author luis.carvajal
 */
public interface CategoryDAO extends CrudRepository<Category, Long>{
    
    @Override
    public Category save(Category Category);
    
    @Query("select c from Category c")
    public List<Category> list();
    
    @Query("select c from Category c where c.id=?1")
    public List<Category> list(Long shopId);

}
