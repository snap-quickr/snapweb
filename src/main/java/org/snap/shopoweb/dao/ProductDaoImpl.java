package org.snap.shopoweb.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.snap.shopoweb.beans.Location;
import org.snap.shopoweb.beans.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

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
        try {
			String SQL = "select * from product_"+locationId+" where productId ='"+productId+"'";
			product = (Product)jdbcTemplate.queryForObject(SQL, new ProductMapper());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			product=null;
		}
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
    
    public HashMap<String,List<Product>> getAllProducts(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        LocationDao locationDao = (LocationDao) context.getBean("locationDao");
        List<Location> listLoc = locationDao.getAllLocations();
        HashMap<String,List<Product>> hashMap = new HashMap<String, List<Product>>();
        for(Location loc:listLoc){
            hashMap.put(loc.getLocationName(), this.getProductsByLocation(loc.getLocationId()));
        }
        ((ConfigurableApplicationContext)context).close();
        return hashMap;
    }
    
    public void addProduct(Product p){
        String sql = "insert into product_"+p.getLocationId()+" values (?,?,?,?,?,?,?)";
        int id = getMaxProductId(p.getLocationId())+1;
        jdbcTemplate.update(sql, new Object[]{id, p.getProductName(),
                p.getProductDetail(), p.getPrice(),p.getCategoryId(),p.getLocationId(),p.getUserId()});
    }

	public HashSet<Product> search(String searchStr,int locationId) {
		// TODO Auto-generated method stub
		List<Product> products=getProductsByLocation(locationId);
		HashSet<Product> returnResult=new HashSet<>();
		for(String str:searchStr.split(" "))
		{
			for(Product product:products)
			{
				if(product.getProductName().contains(str)||product.getProductDetail().contains(str))
				returnResult.add(product);
			}
		}
		
		return returnResult;
	}
}