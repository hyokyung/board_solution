package com.hyo.board.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoardResponseDto {

  private final String name;
  private final int amount;

}
