package org.snap.shopoweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.snap.shopoweb.beans.Product;
import org.snap.shopoweb.beans.User;

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

        this.jdbcTemplate.update(this.user_product_insert,new Object[]{1,productTableName});

        product_insert=product_insert.concat(productTableName);
        product_insert=product_insert.concat(" values(?,?,?,?,?,?,?)");
        this.jdbcTemplate.update(this.product_insert,new Object[]{1,p.getCategoryId(),"abc",p.getLocationId(),p.getProductName(),p.getPrice(),p.getProductDetail()});
    }

    public int getMaxUserId(){
        String sql = "select max(userId) from user";
        int id;
        try{
            id = jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (NullPointerException e){
            e.printStackTrace();
            return 0;
        }
        return id;
    }

    public void saveUser(User u) 
    {
        this.jdbcTemplate.update(this.user_insert,new Object[]{u.getUserId(),u.getUserName(),u.getUserEmail(),u.getUserPassword(),u.getUserContact()});

        //        String tableName="user_";
        //        String id=String.valueOf(u.getUserId());
        //        tableName=tableName.concat(id);
        //
        //        user_product_table=user_product_table.concat(tableName);
        //        user_product_table=user_product_table.concat("(productId int,referencedTable varchar(30))");
        //        this.jdbcTemplate.update(this.user_product_table);

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
        User u;
		try {
			String SQL="select * from user where userEmail=";
			SQL=SQL.concat("'"+email+"'");
			u = (User)this.jdbcTemplate.queryForObject(SQL,new UserMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			u=null;
		}
        return u;
    }

    public User getUserById(int userId){
        User u;
		try {
			String SQL="select * from user where userId=";
			SQL=SQL.concat(String.valueOf(userId));
			u = (User)this.jdbcTemplate.queryForObject(SQL,new UserMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			u=null;
		}
        return u;
    }

    public List<Product> getUserAddedProducts(int userId) {
        String tableName="";
        List<Product> products = new ArrayList<Product>();
        List<Product> p=null;
        for(int i=1 ; i<=10 ; i++) {
            tableName="product_";
            String locationId=String.valueOf(i);
            tableName=tableName.concat(locationId);
            String SQL="select * from ";
            SQL=SQL.concat(tableName);
            SQL=SQL.concat(" where userId=");
            String uId=String.valueOf(userId);
            SQL=SQL.concat(uId);
            p= (List<Product>) jdbcTemplate.query(SQL,new ProductMapper());
            // if(p!=null)
            products.addAll(p);
        }

        return products;
    }
}
