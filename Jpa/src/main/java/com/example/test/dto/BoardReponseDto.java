package com.example.test.dto;

import com.example.test.domain.Board;

import lombok.Getter;

@Getter
public class BoardReponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;

	public BoardReponseDto(Board entity) {
	       this.id = entity.getId();
	       this.title = entity.getTitle();
	       this.content = entity.getContent();
	       this.author = entity.getAuthor();
	   }

}
