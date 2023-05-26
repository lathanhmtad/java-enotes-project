package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NoteModel extends AbstractModel<NoteModel> {
	private String title;
	private String content;
	private UserModel user;
}
