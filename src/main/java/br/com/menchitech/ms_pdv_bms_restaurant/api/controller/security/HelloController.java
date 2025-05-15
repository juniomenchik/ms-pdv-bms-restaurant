package br.com.menchitech.ms_pdv_bms_restaurant.api.controller.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        return "Welcome to MenchiTech! SESSION_ID = " + request.getSession().getId();
    }

    @PostMapping("/")
    public String hello(@RequestBody String body) {
        return body;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}