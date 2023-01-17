/*
 * package com.example.demo.controller;
 * 
 * import java.util.Arrays; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.annotation.Order; import
 * org.springframework.security.authentication.AuthenticationProvider; import
 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import
 * org.springframework.security.config.annotation.web.builders.WebSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.SecurityFilterChain; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.CorsConfigurationSource; import
 * org.springframework.web.cors.UrlBasedCorsConfigurationSource;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class AuthController {
 * 
 * @Autowired private UserDetailsService userDetailsimpl;
 * 
 * @Bean protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.authenticationProvider(authenticationProvider()); }
 * 
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception {
 * 
 * http.csrf().disable().authorizeRequests().requestMatchers("/**",
 * "/registration", "/login").permitAll()
 * .anyRequest().authenticated().and().cors() // .and().httpBasic(); return
 * http.build();
 * 
 * }
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Bean public DaoAuthenticationProvider authenticationProvider() {
 * DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
 * auth.setUserDetailsService(userDetailsimpl);
 * auth.setPasswordEncoder(passwordEncoder()); return auth; }
 * 
 * 
 * }
 */