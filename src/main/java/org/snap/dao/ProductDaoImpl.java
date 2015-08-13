package org.snap.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;





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
		
		 String SQL = "select * from ?";
	      List<Product> products = (List<Product>) jdbcTemplate.queryForObject(SQL,new Object[]{tableName},new ProductMapper());
	      return products;
		
	
	}
	
	

}
