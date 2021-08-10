package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.dto.BoardReponseDto;
import com.example.test.dto.BoardSaveRequestsDto;
import com.example.test.dto.BoardUpdateRequestDto;
import com.example.test.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
	
	private final BoardService boardService;
	
	@PostMapping(value = "/api/v1/board")
	public Long save(@RequestBody BoardSaveRequestsDto requestDto) {
		return boardService.save(requestDto);
	}
	
	@PutMapping(value = "/api/v1/board/{id}")
	public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
		return boardService.update(id, requestDto);
	}
	
	@GetMapping(value = "/api/v1/board/{id}")
	public BoardReponseDto findById(@PathVariable Long id) {
		return boardService.findById(id);
	}
}
