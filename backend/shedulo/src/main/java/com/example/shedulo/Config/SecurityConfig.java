package com.example.shedulo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()  // Allow public access to POST register endpoint
                .requestMatchers(HttpMethod.POST, "/api/users/login").permitAll()    // Allow public access to POST login endpoint
                .anyRequest().authenticated()  // All other endpoints require authentication
                .and()
                .formLogin().disable()  // Disable default form login
                .httpBasic().disable()  // Disable HTTP Basic authentication
                .cors();  // Enable CORS

        return http.build();
    }

}
