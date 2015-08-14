/*
 *  @version     1.0, 14-Aug-2015
 *  @author tanuj
 */
package org.snap.shopoweb.dao;

import java.util.List;

import org.snap.shopoweb.beans.Category;
import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryDaoImpl implements CategoryDao {
    
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Category> getAllCategories(){
        String sql = "select * from category";
        List<Category> categories = jdbcTemplate.query(sql, new CategoryMapper());
        return categories;
    }
}
