package com.erp.ERP.Config;

import com.erp.ERP.Security.JwtAuthFilter;
import com.erp.ERP.Security.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.Security.authentication.AuthenticationManager;
import org.springframework.Security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.Security.config.annotation.web.builders.HttpSecurity;
import org.springframework.Security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.Security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.Security.crypto.password.PasswordEncoder;
import org.springframework.Security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    private final AuthService authService;
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(AuthService authService, JwtAuthFilter jwtAuthFilter) {
        this.authService = authService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/auth/**", "/login").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
