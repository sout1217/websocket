package com.example.websocket.domain.account;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@ToString
public class AccountPayload {

    private String username;

    private String password;

    public Account toEntity(String passwordEncoder) {
        return Account.of(username, passwordEncoder);
    }
}

