/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.dao.CategoryDAO;
import com.alfilsoft.model.Category;
import com.alfilsoft.util.BOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.carvajal
 */
@Service
public class CategoryBOImpl implements CategoryBO {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category save(Category category) throws BOException {
        return categoryDAO.save(category);
    }

    @Override
    public List<Category> list() throws BOException {
        try {
            return categoryDAO.list();
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Category> list(Long shopId) throws BOException {
        try {
            return categoryDAO.list(shopId);
        } catch (Exception e) {
            throw new BOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Category save(Category category, Long shopId) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
