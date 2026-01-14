package com.enesderin.personal_portfolio_backend.config;


import com.enesderin.personal_portfolio_backend.exception.handler.AuthEntryPoint;
import com.enesderin.personal_portfolio_backend.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final AuthEntryPoint authEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/about/admin/**").authenticated()
                .requestMatchers("/cantact-settings/admin/**").authenticated()
                .requestMatchers("/hero-section/admin/**").authenticated()
                .requestMatchers("/project/admin/**").authenticated()
                .requestMatchers("/skill/admin/**").authenticated()
                .requestMatchers("/users/admin/**").authenticated()
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().permitAll()
        );


        http.exceptionHandling(ex -> ex.authenticationEntryPoint(authEntryPoint));
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
