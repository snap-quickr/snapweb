package org.snap.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


public class UserDaoImpl implements UserDao {

	
	private JdbcTemplate jdbcTemplate;
	String user_insert="insert into user values(?,?,?,?,?)";
	String user_product_table="create table ? (productId int,referencedTable varchar(30))";
	String user_product_insert="insert into ? values(?)";
	String product_insert="insert into ? values(?,?,?,?)";
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	
	
	public void saveUser(User u) 
	{
		this.jdbcTemplate.update(this.user_insert,new Object[]{u.getUserId(),u.getUserName(),u.getUserEmail(),u.getUserPassword(),u.getUserContact()});
		
		String tableName="user_";
		String id=String.valueOf(u.getUserId());
		tableName=tableName.concat(id);
		
		this.jdbcTemplate.update(this.user_product_table,new Object[]{tableName});
	}
	
	
	
	public void addUserProduct(int userId,Product p)
	{
		String userTableName="user_";
		String id=String.valueOf(userId);
		userTableName=userTableName.concat(id);
		
		String productTableName="product_";
		String locationId=String.valueOf(p.getLocationId());
		productTableName=productTableName.concat(locationId);
		
		this.jdbcTemplate.update(this.user_product_table,new Object[]{userTableName,productTableName});
		
		
		this.jdbcTemplate.update(this.product_insert,new Object[]{productTableName,p.getProductId(),p.getCategoryId(),p.getUrl(),p.getProductDetail()});
		
	}
	
	
	public List<Product> userAddedProduct(User u)
	{
		
		String userTable="user_";
		String userId=String.valueOf(u.userId);
		userTable=userTable.concat(userId);
		
		String SQL="select * from ?";
		this.jdbcTemplate.update(SQL,new Object[]{userTable});
		
		return null;
	}
	

}
