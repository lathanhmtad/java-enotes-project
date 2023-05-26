package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {
	@Override
	public UserModel mapRow(ResultSet rs) {
		UserModel userModel = new UserModel();
		try {
			userModel.setId(rs.getLong("id"));
			userModel.setFullName(rs.getString("full_name"));
			userModel.setEmail(rs.getString("email"));
			userModel.setPassword(rs.getString("password"));
			userModel.setCreatedDate(rs.getTimestamp("created_date"));
			return userModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
