package com.example.websocket.service;

import com.example.websocket.domain.account.Account;
import com.example.websocket.domain.account.AccountPayload;
import com.example.websocket.domain.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account signIn(AccountPayload accountPayload) {

        Account account = accountRepository.findByUsername(accountPayload.getUsername()).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다"));

        if (! passwordEncoder.matches(accountPayload.getPassword(), account.getPassword()) ) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        return account;
    }
}
