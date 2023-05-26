package com.example.dao;

import java.sql.Timestamp;
import java.util.List;

import com.example.mapper.UserMapper;
import com.example.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> {
	public Long save(UserModel user) {
		user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		String sql = "insert into user (full_name, email, password, created_date) values(?,?,?,?)";
		return insert(sql, user.getFullName(), user.getEmail(), user.getPassword(), user.getCreatedDate());
	}

	public UserModel findOneByEmailAndPassword(String email, String password) {
		String sql = "select * from user where email = ? and password = ?";
		List<UserModel> users = query(sql, new UserMapper(), email, password);
		return users.isEmpty() ? null : users.get(0);
	}
}
