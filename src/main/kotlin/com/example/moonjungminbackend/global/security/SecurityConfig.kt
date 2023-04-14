package com.example.moonjungminbackend.global.security

import com.example.moonjungminbackend.global.security.jwt.JwtProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig (
        private val jwtProvider: JwtProvider,
        private val objectMapper: ObjectMapper
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .formLogin().disable()
                .csrf().disable()
                .cors()

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
                .authorizeHttpRequests()

                .antMatchers(HttpMethod.GET, "/login/oauth2/code/google").permitAll()

                .anyRequest().authenticated()

                .and()
                .apply(FilterConfig(jwtProvider, objectMapper))

        return http.build()
    }

}