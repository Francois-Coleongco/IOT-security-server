package Fran.backend_server;

import Fran.backend_server.auth.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class BackendServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendServerApplication.class, args);
	}

}
