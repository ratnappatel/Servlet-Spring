package com.gl.service;

import java.util.HashMap;

import com.gl.dao.UserDAO;
import com.gl.entity.User;

public class UserService {
	UserDAO dao;
	HashMap<String,User> users;
	public UserService() {
		this.dao=new UserDAO();
		users=dao.getUsers();
	}
	
	public boolean authenticate(String username,String password)
	{
		boolean flag=false;
		User user=users.get(username);
		if(user!=null)
		{
			if(user.getPassword().equals(password))
				flag=true;
			else
				flag=false;
		}
		else
			flag=false;
		return flag;
			
	}

}
