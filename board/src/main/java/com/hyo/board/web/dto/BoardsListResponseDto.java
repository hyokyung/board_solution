package com.hyo.board.web.dto;

import java.time.LocalDateTime;

import com.hyo.board.domain.boards.Boards;

import lombok.Getter;

@Getter
public class BoardsListResponseDto {
  private Long id;
  private String title;
  private String author;
  private LocalDateTime modifiedDate;

  public BoardsListResponseDto(Boards entity){
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.author = entity.getAuthor();
    this.modifiedDate = entity.getModifiedDate();
  }

}
