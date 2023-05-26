package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostModel extends AbstractModel<PostModel> {
	private String title;
	private String content;
	private Long userId;
}
