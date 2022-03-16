package com.hyo.board.domain.boards;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardsRepositoryTest {

  @Autowired
  BoardsRepository boardsRepository;

  @After
  public void cleanup(){
    boardsRepository.deleteAll();
  }

  @Test
  public void saveAndRead(){

    String title = "테스트 게시글";
    String content ="테스트 본문";

    boardsRepository.save(Boards.builder()
                    .title(title)
                    .content(content)
                    .author("florida90@naver.com")
                    .build());

    List<Boards> boardsList = boardsRepository.findAll();

    Boards boards = boardsList.get(0);
    assertThat(boards.getTitle()).isEqualTo(title);
    assertThat(boards.getContent()).isEqualTo(content);

  }

  @Test
  public void BaseTimeEntity_regist(){
    LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
    boardsRepository.save(Boards.builder()
                          .title("title")
                          .content("content")
                          .author("author")
                          .build());

    List<Boards> boardsList = boardsRepository.findAll();
    Boards boards = boardsList.get(0);

    System.out.println(">>>>>>>>>>>>>>>> CreateedDate="+boards.getCreatedDate()+", modifiedDate ="+boards.getModifiedDate());

    assertThat(boards.getCreatedDate()).isAfter(now);
    assertThat(boards.getModifiedDate()).isAfter(now);
  }

}
