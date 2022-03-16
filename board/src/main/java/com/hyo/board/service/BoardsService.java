package com.hyo.board.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.hyo.board.domain.boards.Boards;
import com.hyo.board.domain.boards.BoardsRepository;
import com.hyo.board.web.dto.BoardsListResponseDto;
import com.hyo.board.web.dto.BoardsResponseDto;
import com.hyo.board.web.dto.BoardsSaveRequestDto;
import com.hyo.board.web.dto.BoardsUpdatesRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardsService {
  private final BoardsRepository boardsRepository;

  @Transactional
  public Long save(BoardsSaveRequestDto requestDto){
    return boardsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, BoardsUpdatesRequestDto requestDto){
    Boards boards = boardsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));
    boards.update(requestDto.getTitle(), requestDto.getContent());

    return id;
  }

  @Transactional
  public BoardsResponseDto findById (Long id){
    Boards entity = boardsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));
    return new BoardsResponseDto(entity);
  }

  @Transactional
  public List<BoardsListResponseDto> findAllDesc(){
    return boardsRepository.findAllDesc().stream().map(BoardsListResponseDto::new).collect(Collectors.toList());
  }

}
