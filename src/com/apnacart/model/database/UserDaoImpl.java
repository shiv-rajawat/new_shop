package com.apnacart.model.database;

import java.sql.*;

import com.apnacart.model.pojo.UserPojo;

public class UserDaoImpl implements UserDao {
	
	
	Connection con;
	public static UserPojo userObj = new UserPojo();
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://my-first-database.cbem1g9mbvmp.us-east-2.rds.amazonaws.com:3306/ShoppingApplication", "master", "mastermaster");		
	}
	
	public void registerUser(UserPojo userObj) throws ClassNotFoundException, SQLException {
		String insertStatement = "insert into UserDetails (username,password) values (?,?);";
		PreparedStatement preparedStatement = con.prepareStatement(insertStatement);
		preparedStatement.setString(1, userObj.getName());
		preparedStatement.setString(2, userObj.getPassword());
		preparedStatement.executeUpdate();
		con.close();		
	}

	
	public boolean loginUser(UserPojo userObj) throws ClassNotFoundException, SQLException {
		
		String query="select password, userid from UserDetails where username=?;";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, userObj.getName());
		ResultSet rs = preparedStatement.executeQuery();
		
		if (rs.next()) {
			
			if((rs.getString(1)).equals(userObj.getPassword())) {
				userObj.setId(rs.getInt(2));
				UserDaoImpl.userObj = userObj;
				return(true);
			}
				
		}				
		
		return(false);
	}
}
