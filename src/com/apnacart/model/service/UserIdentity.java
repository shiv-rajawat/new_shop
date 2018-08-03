package com.apnacart.model.service;



import java.sql.SQLException;

import com.apnacart.model.database.UserDao;
import com.apnacart.model.database.UserDaoImpl;
import com.apnacart.model.pojo.UserPojo;

public class UserIdentity {
	
	public void doRegister(String userName, String password) {
		
		UserPojo userObj = new UserPojo();
      	userObj.setName(userName);
      	userObj.setPassword(password);
      	
		UserDao userDaoObj = new UserDaoImpl();
		try {
			userDaoObj.connect();
			userDaoObj.registerUser(userObj);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
				
	}
	
	public boolean doLogin(String userName, String password) {
		
		UserPojo userObj = new UserPojo();
      	userObj.setName(userName);
      	userObj.setPassword(password);
      	
      	UserDao userDaoObj = new UserDaoImpl();
      	try {
			userDaoObj.connect();
			if(userDaoObj.loginUser(userObj)!= false) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;	
		
	}

}
