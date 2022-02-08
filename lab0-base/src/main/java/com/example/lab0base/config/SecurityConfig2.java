package com.example.lab0base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfig2 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/403.html");

        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/index.html").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/test/hello").permitAll()
//                .antMatchers("/test/index").hasAuthority("admin")
//                TODO 这里使用单个字符串逗号分割，多个字符串区别
//                TODO 授权验证怎么实现的
//                .antMatchers("/test/index").hasAnyAuthority("admin","common")
//                .antMatchers("/test/index").hasRole("DBA")
                .anyRequest().authenticated()
                .and().csrf().disable();

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
