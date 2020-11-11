package com.example.websocket.service;

import com.example.websocket.domain.account.Account;
import com.example.websocket.domain.account.AccountPayload;
import com.example.websocket.domain.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account signUp(AccountPayload accountPayload) {

        boolean exists = accountRepository.existsByUsername(accountPayload.getUsername());

        if ( exists ) {
            throw new IllegalArgumentException("중복된 아이디명 입니다");
        }

        String encodePassword = passwordEncoder.encode(accountPayload.getPassword());

        return accountRepository.save(accountPayload.toEntity(encodePassword));
    }
}
