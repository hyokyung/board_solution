package com.hyo.board.web.api;

import javax.servlet.http.HttpSession;

import com.config.auth.dto.SessionUser;
import com.hyo.board.service.BoardsService;
import com.hyo.board.web.dto.BoardsResponseDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

  private final BoardsService boardsService;
  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model){

    model.addAttribute("boards", boardsService.findAllDesc());

    //FIXME user 못받아오는거 수정하기 왜 못받아올까 ㅠㅠ
    SessionUser user = (SessionUser) httpSession.getAttribute("user");
    if(user != null){
      model.addAttribute("userName", user.getName());
    }

    return "index";
  }

  @GetMapping("/boards/save")
  public String boardsSave(){
    return "boards-save";
  }

  @GetMapping("/boards/update/{id}")
  public String boardsUpdate(@PathVariable Long id, Model model){
    BoardsResponseDto dto = boardsService.findById(id);
    model.addAttribute("boards", dto);

    return "boards-update";
  }

}
