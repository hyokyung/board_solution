package com.hyo.board.web.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.hyo.board.web.api.payload.RegistrationPayload;

@WebMvcTest(RegistrationController.class)
@ExtendWith(SpringExtension.class)
public class RegistrationControllerTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void registration_payload_shouldFailAndReturn400() throws Exception {
    mvc.perform(post("/api/v1/register")).andExpect(status().is(400));
  }

  @Test
  public void register_blankUsername_shouldFailAndReturn400() throws Exception {
    RegistrationPayload payload = RegistrationPayload.builder().build();
  //   mvc.perform(
  //     // post(TEST_URL)
  //     //   .contentType(MediaType.APPLICATION_JSON)
  //     //   .content(JsonUtil.toJson(payload)))
  //     // .andExpect(status().is(400))
  //     // .andExpect(jsonPath("$.errorCode").value("ARGUMENT_0001"));
  // }
  }
}
