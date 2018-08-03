package com.apnacart.model.database;

import java.sql.SQLException;

import com.apnacart.model.pojo.UserPojo;

public interface UserDao {
	public void connect() throws ClassNotFoundException, SQLException;
	public void registerUser(UserPojo userObj) throws ClassNotFoundException, SQLException;
	public boolean loginUser(UserPojo userObj) throws ClassNotFoundException, SQLException;
	

}
