/*
 *  @version     1.0, 14-Aug-2015
 *  @author tanuj
 */
package org.snap.shopoweb.dao;

import java.util.List;

import org.snap.shopoweb.beans.Category;

public interface CategoryDao {
    public List<Category> getAllCategories();
}
