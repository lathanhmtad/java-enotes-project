package com.example.services;

import com.example.dao.UserDAO;
import com.example.model.UserModel;

public class UserService {
	
	private UserDAO dao;
	
	
	public UserService() {
		dao = new UserDAO();
	}


	public Long save(UserModel model) {
		return dao.save(model);
	}


	public UserModel findOneByEmailAndPassword(String email, String password) {
		
		return dao.findOneByEmailAndPassword(email, password);
	}
}
