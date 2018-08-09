/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.model.Category;
import com.alfilsoft.util.BOException;
import java.util.List;

/**
 *
 * @author luis.carvajal
 */
public interface CategoryBO {
    
    public Category save(Category category)throws BOException;
    
    public List<Category> list()throws BOException;
    
    public List<Category> list(Long shopId)throws BOException;
    
}
