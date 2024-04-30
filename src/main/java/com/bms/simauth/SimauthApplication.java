package com.bms.simauth;

import com.bms.simauth.domain.ApplicationUser;
import com.bms.simauth.domain.Role;
import com.bms.simauth.repository.RoleRepository;
import com.bms.simauth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SimauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimauthApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		return args -> {

			if (roleRepository.findByAuthority("ADMIN").isPresent()) return;

			Role savedAdminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(savedAdminRole);

			ApplicationUser adminUser = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), roles);
			userRepository.save(adminUser);

		};
	}

}
