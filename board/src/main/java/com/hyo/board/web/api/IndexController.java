package com.hyo.board.web.api;

import com.hyo.board.service.BoardsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

  private final BoardsService boardsService;

  @GetMapping("/")
  public String index(Model model){

    model.addAttribute("boards", boardsService.findAllDesc());

    return "index";
  }

  @GetMapping("/boards/save")
  public String boardsSave(){
    return "boards-save";
  }

}
