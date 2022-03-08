package com.gl.dao;

import java.util.HashMap;

import com.gl.entity.User;

public class UserDAO {
	private HashMap<String,User> users=new HashMap<String,User>();
	public UserDAO() {
		users.put("ratna",new User("Ratna Patel","ratnabpatel@gmail.com","9529216356","password"));
	}
	public HashMap<String, User> getUsers() {
		return users;
	}
	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}
	

}
