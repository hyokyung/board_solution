package com.hyo.board.domain.boards;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.hyo.board.domain.BaseTimeEntity;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;


@Getter
@NoArgsConstructor
@Entity
public class Boards extends BaseTimeEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length =500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @Builder
  public Boards(String title, String content, String author){

    this.title = title;
    this.content = content;
    this.author = author;
  }

  public void update(String title, String content){
    this.title = title;
    this.content = content;
  }


}
