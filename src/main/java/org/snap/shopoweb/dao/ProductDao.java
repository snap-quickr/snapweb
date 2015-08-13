package org.snap.shopoweb.dao;

import java.util.List;

import org.snap.shopoweb.beans.Product;

public interface ProductDao {
	
	List<Product> selectProductByLocation(int locationId);

}
