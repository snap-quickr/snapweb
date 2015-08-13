package org.snap.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import org.snap.dao.*;

public class UserDaoImpl implements UserDao {


	private JdbcTemplate jdbcTemplate;
	String user_insert="insert into user values(?,?,?,?,?)";
	String user_product_table="create table ";
	String user_product_insert="insert into ";
	String product_insert="insert into ";

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addUserProduct(int userId,Product p){
		String userTableName="user_";
		String id=String.valueOf(userId);
		userTableName=userTableName.concat(id);
		user_product_insert=user_product_insert.concat(userTableName);
		user_product_insert=user_product_insert.concat(" values(?,?)");

		String productTableName="product_";
		String locationId=String.valueOf(p.getLocationId());
		productTableName=productTableName.concat(locationId);

		this.jdbcTemplate.update(this.user_product_insert,new Object[]{p.getProductId(),productTableName});

		product_insert=product_insert.concat(productTableName);
		product_insert=product_insert.concat(" values(?,?,?,?)");
		this.jdbcTemplate.update(this.product_insert,new Object[]{p.getProductId(),p.getCategoryId(),p.getUrl(),p.getProductDetail()});
	}
	
	public int getMaxUserId(){
	    String sql = "select max(userId) from user";
	    int id = jdbcTemplate.queryForObject(sql, Integer.class);
	    return id;
	}

	public void saveUser(User u) 
	{
		this.jdbcTemplate.update(this.user_insert,new Object[]{u.getUserId(),u.getUserName(),u.getUserEmail(),u.getUserPassword(),u.getUserContact()});

		String tableName="user_";
		String id=String.valueOf(u.getUserId());
		tableName=tableName.concat(id);

		user_product_table=user_product_table.concat(tableName);
		user_product_table=user_product_table.concat("(productId int,referencedTable varchar(30))");
		this.jdbcTemplate.update(this.user_product_table);

	}

	//	public List<Product> getUserAddedProduct(String userId)
	//	{
	//		
	//		String userTable="user_";
	//		
	//		userTable=userTable.concat(userId);
	//		
	//		String SQL="select * from ?";
	//		this.jdbcTemplate.update(SQL,new Object[]{userTable});
	//		
	//		return null;
	//	}

	public User getUser(String email){
		String SQL="select * from user where userEmail=";
		SQL=SQL.concat(email);
		User u=(User)this.jdbcTemplate.queryForObject(SQL,new UserMapper());
		return u;
	}
}
