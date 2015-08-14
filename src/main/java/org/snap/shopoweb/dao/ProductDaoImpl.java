package org.snap.shopoweb.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.snap.shopoweb.beans.*;

public class ProductDaoImpl implements ProductDao{


    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Product> getProductsByLocation(int locationId) {

        String tableName="product_";
        String id=String.valueOf(locationId);
        tableName=tableName.concat(id);
        String SQL = "select * from ";
        SQL=SQL.concat(tableName);
        List<Product> products = (List<Product>) jdbcTemplate.query(SQL,new ProductMapper());
        return products;
    }

    public Product getProductsByLocationAndProductId(int locationId, int productId){
        Product product = new Product();
        String tableName="product_";
        String id=String.valueOf(locationId);
        tableName=tableName.concat(id);
        String SQL = "select * from ";
        SQL = SQL.concat(tableName);
        SQL = SQL.concat(" where productId = ?");
        product = (Product)jdbcTemplate.queryForObject(SQL, new ProductMapper());
        return product;
    }
    
    private int getMaxProductId(int locationID){
        String sql = "select max(productId) from product_"+locationID;
        int id;
        try{
            id = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (NullPointerException e){
            e.printStackTrace();
            return 0;
        }
        return id;
    }
    
    public void addProduct(Product p){
        String sql = "insert into product_"+p.getLocationId()+" values (?,?,?,?,?,?,?)";
        int id = getMaxProductId(p.getLocationId())+1;
        jdbcTemplate.update(sql, new Object[]{id, p.getProductName(),
                p.getProductDetail(), p.getPrice(),p.getCategoryId(),p.getLocationId(),p.getUserId()});
    }
}