package com.thincrs.open311Thincrs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/**").permitAll() // Rutas públicas
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/login") // Ruta para la autenticación
                .defaultSuccessUrl("/api/") // Ruta después de un inicio de sesión exitoso
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .permitAll();
    }
}
