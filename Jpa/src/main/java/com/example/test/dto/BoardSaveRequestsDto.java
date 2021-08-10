package com.example.test.dto;

import com.example.test.domain.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestsDto {
	private String title;
	private String content;
	private String author;
	
	@Builder
	public BoardSaveRequestsDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Board toEntity() {
		return Board.builder()
					.title(title)
					.content(content)
					.author(author)
					.build();
	}

}
