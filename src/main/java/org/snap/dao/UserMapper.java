package org.snap.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		User user=new User();
		user.setUserContact(rs.getString("userContact"));
		user.setUserEmail(rs.getString("userEmail"));
		user.setUserId(rs.getInt("userId"));
		user.setUserName(rs.getString("userName"));
		user.setUserPassword(rs.getString("userPassword"));
		return user;
	}

}