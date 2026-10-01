package com.bms.blog;

import com.bms.blog.domain.entities.User;
import com.bms.blog.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.TimeZone;

@SpringBootApplication
@CrossOrigin
public class BlogApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(BlogApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			String email = "user@test.com";
			userRepository.findByEmail(email).orElseGet(() -> {
				User newUser = User.builder()
						.name("Test User")
						.email(email)
						.password(passwordEncoder.encode("password"))
						.build();
				return userRepository.save(newUser);
			});
		};
	}

}
