package com.hyo.board.web.api;

import com.hyo.board.web.api.payload.RegistrationPayload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
  @PostMapping("/api/v1/register")
  public String registe(@RequestBody RegistrationPayload payload) {
    return "OK";
  }
}
