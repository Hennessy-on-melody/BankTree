package com.zerobase.banktree.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Order(0)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors()
                .and()
                .csrf().disable()
                .httpBasic().disable();

        return httpSecurity.build();
    }

    @Bean
    public SecurityFilterChain resources(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/member/register")
                .permitAll()
                .anyRequest()
                .authenticated();

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

}
