package com.example.lab0base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder()).withUser("zs").password
                (bCryptPasswordEncoder().encode("zs")).roles("admin");
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("zs")
//                .password("zs")
//                .roles("USER")
//                .build();
//        UserDetails userDetails1 = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin123")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails, userDetails1);
//    }
}
