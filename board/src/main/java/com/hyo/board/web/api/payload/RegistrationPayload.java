package com.hyo.board.web.api.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationPayload {
    private Long id;
    private String username;
    private String emailAddress;
    private String password;
}
