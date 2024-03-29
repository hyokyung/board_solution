package com.hyo.board.web.api;

import com.hyo.board.service.BoardsService;
import com.hyo.board.web.dto.BoardsResponseDto;
import com.hyo.board.web.dto.BoardsSaveRequestDto;
import com.hyo.board.web.dto.BoardsUpdatesRequestDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardsApiController {

  private final BoardsService boardsService;

  @PostMapping("/api/v1/writes")
  public Long save(@RequestBody BoardsSaveRequestDto requestDto){
    return boardsService.save(requestDto);
  }


  @PutMapping("/api/v1/writes/{id}")
  public Long update(@PathVariable Long id, @RequestBody BoardsUpdatesRequestDto requestDto){
    return boardsService.update(id, requestDto);
  }

  @GetMapping("/api/v1/writes/{id}")
  public BoardsResponseDto findById(@PathVariable Long id){
    return boardsService.findById(id);
  }

  @DeleteMapping("/api/v1/writes/{id}")
  public Long delete(@PathVariable Long id){
    boardsService.delete(id);
    return id;
  }


}
