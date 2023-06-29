package com.nagarro.springassignment.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.springassignment.dao.UserDao;

import com.nagarro.springassignment.model.*;



@Service
public class UserService {


	@Autowired
	private UserDao userDao;
	
	
	public  void addUserEntries(User user)
	{
		try 
		{
			int id=this.register(user);
			System.out.println(id);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public int register(User user)
	{
		int id=this.userDao.addUser(user);
		return id;
		
	}

		
	
}
