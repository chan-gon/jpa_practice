package com.example.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.domain.Board;
import com.example.test.dto.BoardReponseDto;
import com.example.test.dto.BoardSaveRequestsDto;
import com.example.test.dto.BoardUpdateRequestDto;
import com.example.test.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Transactional
	public Long save(BoardSaveRequestsDto requestDto) {
		return boardRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, BoardUpdateRequestDto requestDto) {
		Board board = boardRepository.findById(id)
										.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
		
		board.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}
	
	public BoardReponseDto findById(Long id) {
		Board entity = boardRepository.findById(id)
										.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
		
		return new BoardReponseDto(entity);
	}
	

}
