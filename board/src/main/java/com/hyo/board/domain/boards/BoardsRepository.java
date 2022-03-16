package com.hyo.board.domain.boards;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardsRepository extends JpaRepository<Boards,Long> {
  @Query("SELECT b FROM Boards b ORDER BY b.id DESC")
  List<Boards> findAllDesc();
}
