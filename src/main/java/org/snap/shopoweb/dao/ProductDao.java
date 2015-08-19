package org.snap.shopoweb.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.snap.shopoweb.beans.Product;

public interface ProductDao {	
	List<Product> getProductsByLocation(int locationId);
	public void addProduct(Product p);
	public HashMap<String,List<Product>> getAllProducts();
	public Product getProductsByLocationAndProductId(int locationId, int productId);
	public HashSet<Product> search(String searchStr, int locationId);
}
