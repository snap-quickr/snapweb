package org.snap.dao;

import java.util.List;

public interface ProductDao {
	
	List<Product> selectProductByLocation(int locationId);

}
