package com.sparata.lec01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz

                        // image 폴더를 login 없이 허용
                        .antMatchers("/images/**").permitAll()
                        // css 폴더를 login 없이 허용
                        .antMatchers("/css/**").permitAll()
                        // 어떤 요청이든 '인증'
                        .anyRequest().authenticated()

                )

                // 로그인 기능 허용
                .formLogin() // 로그인 기능작동
                .loginPage("/user/login") // 사용자 정의 페이지 경로
                .defaultSuccessUrl("/") // 로그인 성공 시 이동 페이지 경로
                .failureUrl("/user/login?error") // 로그인 실패 시 이동 페이지 경로

                .permitAll();
        
                

        return http.build();
    }
}