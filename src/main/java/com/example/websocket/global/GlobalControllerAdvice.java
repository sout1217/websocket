package com.example.websocket.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String exception (Exception e, RedirectAttributes redirectAttributes) {
        log.error(e.getMessage());

        // FlashAttribute 는 1회성으로 HomeController 에서 String message 를 해도 잡히지 않는다
        // addAttribute 를 사용한 경우는 잡히며, url 쿼리에 입력된다.
        redirectAttributes.addFlashAttribute("message", e.getMessage());
        return "redirect:/sign-in";
    }
}
