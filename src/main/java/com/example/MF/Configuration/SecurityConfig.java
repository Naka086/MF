package com.becoder.config;


import com.example.MF.Repository.UserRepository;
import com.example.MF.Service.Impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.
			authorizeHttpRequests((authz) -> authz
								.requestMatchers("/admin/**").hasRole("ADMIN")
								.requestMatchers("/manager/**").hasRole("MANAGER")
								.requestMatchers("/fresher/**").hasRole("FRESHER")
								.requestMatchers("/home", "/login").permitAll()
								.anyRequest().authenticated()
			)
				.exceptionHandling()
				.and()
				.formLogin()
				.loginPage("/login").permitAll()
				.and()
				.logout()
				.permitAll()
				.and();
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
		return new UserServiceImpl(userRepository);
	}
}
