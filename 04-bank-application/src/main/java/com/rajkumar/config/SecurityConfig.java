package com.rajkumar.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // @formatter: off
        return http.authorizeHttpRequests(request -> {
            request
            .requestMatchers("/api/v1/accounts/loggedinaccount", 
                    "/api/v1/balances/loggedinbalance", 
                    "/api/v1/cards/loggedincard",
                    "/api/v1/loans/loggedinloan"
                    ).authenticated()
            .requestMatchers("/api/v1/contacts/loggedincontact",
                    "/api/v1/notices/loggedinnotice").permitAll();
        })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
        // @formatter: on
    }

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
