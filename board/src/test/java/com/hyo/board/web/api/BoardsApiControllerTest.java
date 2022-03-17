package com.hyo.board.web.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.hyo.board.domain.boards.Boards;
import com.hyo.board.domain.boards.BoardsRepository;
import com.hyo.board.web.dto.BoardsSaveRequestDto;
import com.hyo.board.web.dto.BoardsUpdatesRequestDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardsApiControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private BoardsRepository boardsRepository;

  @After
  public void tearDown() throws Exception{
    boardsRepository.deleteAll();
  }

  @Test
  public void board_regist() throws Exception {

    String title = "title";
    String content = "content";
    BoardsSaveRequestDto requestDto = BoardsSaveRequestDto.builder()
                                      .title(title)
                                      .content(content)
                                      .author("author")
                                      .build();

    String Url = "http://localhost:"+port+"/api/v1/writes";

    ResponseEntity<Long> responseEntity = restTemplate.postForEntity(Url,requestDto,Long.class);

    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isGreaterThan(0L);

    List<Boards> all = boardsRepository.findAll();
    assertThat(all.get(0).getTitle()).isEqualTo(title);
    assertThat(all.get(0).getContent()).isEqualTo(content);

  }

    @Test
    public void writeAndUpdate() throws Exception{

      Boards saveBoards = boardsRepository.save(Boards.builder()
                                          .title("title")
                                          .content("content")
                                          .author("author")
                                          .build());

      Long updateId = saveBoards.getId();
      String expectedTitle = "title2";
      String expectedContent = "content2";

      BoardsUpdatesRequestDto requestDto = BoardsUpdatesRequestDto.builder()
                                            .title(expectedTitle)
                                            .content(expectedContent)
                                            .build();

      String url = "http://localhost:"+port+"/api/v1/writes/"+updateId;

      HttpEntity<BoardsUpdatesRequestDto> requestEntity = new HttpEntity<>(requestDto);

      ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

      assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(responseEntity.getBody()).isGreaterThan(0L);

      List<Boards> all = boardsRepository.findAll();
      assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
      assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
  }

}
