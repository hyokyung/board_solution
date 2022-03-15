package com.hyo.board.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardsUpdatesRequestDto {

  private String title;
  private String content;

  @Builder
  public BoardsUpdatesRequestDto(String title, String content){

    this.title = title;
    this.content = content;

  }

}
