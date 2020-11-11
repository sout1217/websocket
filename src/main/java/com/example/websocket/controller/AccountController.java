package com.example.websocket.controller;

import com.example.websocket.domain.account.Account;
import com.example.websocket.domain.account.AccountPayload;
import com.example.websocket.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final SignUpService signUpService;

    @PostMapping("/sign-up")
    public ResponseEntity<Account> signUp(@RequestBody AccountPayload accountPayload) {
        log.info("send value {}", accountPayload);

        Account account = signUpService.signUp(accountPayload);

        return ResponseEntity.ok(account);
    }
}
