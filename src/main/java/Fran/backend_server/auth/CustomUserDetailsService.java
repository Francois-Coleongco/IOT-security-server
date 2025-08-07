package Fran.backend_server.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		var role = "USER";

		if (username.startsWith("DEVICE-")) {
			role = "DEVICE"; // login is for an IOT device
		}

		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
				.password(user.getPassword()).roles(role).build();

	}

}
