package Fran.backend_server.auth;

import Fran.backend_server.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final TokenService _token_service;

    public AuthController(TokenService tokenService) {
        _token_service = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication auth) {
        System.out.println("starting token in auth controller");
        return _token_service.generateToken(auth);
    }

}
