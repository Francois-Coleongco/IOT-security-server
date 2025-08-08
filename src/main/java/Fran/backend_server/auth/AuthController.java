package Fran.backend_server.auth;

import Fran.backend_server.service.TokenService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	private final TokenService token_service;
	private final AuthenticationManager authManager;

	public AuthController(TokenService tokenService, AuthenticationManager authManager) {
		this.token_service = tokenService;
		this.authManager = authManager;

	}

	@PostMapping("/token")
	public String token(@RequestParam String username,
			@RequestParam String password) {

		System.out.println("starting token in auth controller\n");

		System.out.println("username: " + username);
		System.out.println("password: " + password);

		Authentication authedAuth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		return this.token_service.generateToken(authedAuth);
	}

}
