package com.hyo.board.config.auth.dto;

import java.io.Serializable;

import com.hyo.board.domain.user.User;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import lombok.Getter;

@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
