package net.polyomino24.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/me")
    public Object me(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "未認証";
        }
        return authentication.getPrincipal(); // 認証済みユーザー情報
    }
}
