package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserModel extends AbstractModel<UserModel> {
	private String fullName;
	private String email;
	private String password;
}
