package com.hyo.web.dto;

import com.hyo.board.web.dto.BoardResponseDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;




public class BoardResponseDtoTest {



  @Test
  public void lombokTest() throws Exception {
    //given
    String name = "test";
    int amount = 1000;

    BoardResponseDto dto = new BoardResponseDto(name,amount);

    assertThat(dto.getName()).isEqualTo(name);
    assertThat(dto.getAmount()).isEqualTo(amount);



  }

}
