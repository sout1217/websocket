package com.example.websocket.controller;

import com.example.websocket.domain.account.Account;
import com.example.websocket.domain.account.AccountPayload;
import com.example.websocket.service.SignInService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SignInService signInService;

    @GetMapping(value = {"/", "/index", "/api"})
    public String index() {
        return "index";
    }

    @GetMapping("/sign-up")
    public void signUp() {
    }

    @GetMapping("/sign-in")
    public void signIn() {
    }

    @PostMapping("/sign-in")
    public String signIn(AccountPayload accountPayload, HttpSession session) {
        // Model 로 사용하려면 @Setter 가 있어야 한다
        log.info("accountPayload {}", accountPayload);

        Account account = signInService.signIn(accountPayload);

        session.setAttribute("user", account);

        return "redirect:/";
    }
}
