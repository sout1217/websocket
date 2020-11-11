package com.example.websocket.init;

import com.example.websocket.domain.account.Account;
import com.example.websocket.domain.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminAccount implements SpringApplicationRunListener {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Override
    public void running(ConfigurableApplicationContext context) {

        Account account = Account.of("root", passwordEncoder.encode("1234"));

        accountRepository.save(account);
    }
}
