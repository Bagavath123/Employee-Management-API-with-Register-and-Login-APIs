package com.example.lohia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends SecurityFilterAutoConfiguration {

//	@Autowired
//    private UserDetailsService userDetailsService;
//    
//	@Bean
//	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
//		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
