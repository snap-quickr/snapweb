package org.snap.shopoweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.snap.shopoweb.beans.Product;
import org.springframework.jdbc.core.RowMapper;


public class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();		      
        product.setProductId(rs.getInt("productId"));
        product.setCategoryId(rs.getInt("categoryId"));
        product.setLocationId(rs.getInt("locationId"));
        product.setProductDetail(rs.getString("productDetail"));
        product.setProductName(rs.getString("productName"));
        product.setUserId(rs.getInt("userId"));
        product.setPrice(rs.getInt("price"));
        return product;
    }

}
