package org.snap.shopoweb.dao;

import org.snap.shopoweb.beans.*;

public interface UserDao {
	
	void saveUser(User u);
	void addUserProduct(int userId,Product p);
	public User getUserById(int userId);
	public User getUserByEmail(String email);
	public int getMaxUserId();
}
