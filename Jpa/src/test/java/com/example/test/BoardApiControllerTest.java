package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.test.domain.Board;
import com.example.test.dto.BoardSaveRequestsDto;
import com.example.test.repository.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@After
	public void tearDown() throws Exception{
		boardRepository.deleteAll();
	}
	
	@Test
	public void Board_등록() throws Exception{
		// given
		String title = "title";
		String content = "content";
		BoardSaveRequestsDto requestDto = BoardSaveRequestsDto.builder()
																.title(title)
																.content(content)
																.author("author")
																.build();
		
		String url = "http://localhost:" + port + "/api/v1/board";
		
		// when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
		
		// then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<Board> all = boardRepository.findAll();
		assertThat(all.get(0).getTitle()).isEqualTo(title);
		assertThat(all.get(0).getContent()).isEqualTo(content);
	}
	
	
}
