package com.apnacart.model.pojo;

public class UserPojo {
	private int userId;
    private String userName;
    private String password;

    public int getId() {
        return userId;
    }
    public void setId(int id) {
        this.userId = id;
    }
    public String getName() {
        return userName;
    }
    public void setName(String name) {
        this.userName = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password=password;
    }	

}
