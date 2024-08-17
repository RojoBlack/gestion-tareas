package com.tareas.gestiontareas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite todas las solicitudes sin autenticación
                )
                .csrf(csrf -> csrf.disable()) // Deshabilita CSRF
                .httpBasic(httpBasic -> httpBasic.disable()) // Deshabilita la autenticación básica
                .formLogin(formLogin -> formLogin.disable()); // Deshabilita el formulario de login

        return http.build();
    }
}