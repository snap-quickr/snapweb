package org.snap.dao;

public interface UserDao {
	
	void saveUser(User u);
	void addUserProduct(int userId,Product p);

}
