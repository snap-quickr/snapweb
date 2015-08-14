/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 14-Aug-2015
 *  @author tanuj
 */
package org.snap.shopoweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.snap.shopoweb.beans.Category;
import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<Category> {
    
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();              
        category.setCategoryId(rs.getInt("categoryId"));
        category.setCategoryName(rs.getString("categoryName"));
        return category;
    }
}
