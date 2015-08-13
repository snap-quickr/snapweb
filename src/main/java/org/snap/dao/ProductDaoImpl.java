package org.snap.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import org.snap.dao.*;

public class ProductDaoImpl implements ProductDao{


	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Product> selectProductByLocation(int locationId) {

		String tableName="product_";
		String id=String.valueOf(locationId);
		tableName=tableName.concat(id);

		String SQL = "select * from ";
		SQL=SQL.concat(tableName);

		List<Product> products = (List<Product>) jdbcTemplate.query(SQL,new ProductMapper());
		return products;


	}
<<<<<<< HEAD


=======
	
	public Product selectProductByLocationAndProductId(int locationId, int productId){
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
>>>>>>> origin/master

}
