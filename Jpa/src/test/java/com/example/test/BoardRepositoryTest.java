package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.test.domain.Board;
import com.example.test.repository.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	 @Autowired
	    BoardRepository boardRepository;

	    @After
	    public void cleanup() {
	    	boardRepository.deleteAll();
	    }

	    @Test
	    public void 게시글저장_블러오기() {
	        //given
	        String title = "테스트 게시글";
	        String content = "테스트 본문";

	        boardRepository.save(Board.builder()
	                                    .title(title)
	                                    .content(content)
	                                    .author("changon@gmail.com")
	                                    .build());

	        //when
	        List<Board> boardList = boardRepository.findAll();

	        //then
	        Board boards = boardList.get(0);
	        assertThat(boards.getTitle()).isEqualTo(title);
	        assertThat(boards.getContent()).isEqualTo(content);
	    }

}
