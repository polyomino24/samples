package net.polyomino24.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/users")
    public String getUsers() {
        // This is a placeholder for user retrieval logic
        return "List of users";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            // 認証情報をセキュリティコンテキストにセット
            SecurityContextHolder.getContext().setAuthentication(auth);

            // ★ここでセッションを明示的に作成 → JSESSIONIDクッキーが発行される
            request.getSession(true);
            // 認証成功時の処理（例: JWTトークン発行やユーザー情報返却）
            return "ログイン成功";
        } catch (AuthenticationException e) {
            // 認証失敗時
            throw new RuntimeException("認証失敗");
        }
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }
}
