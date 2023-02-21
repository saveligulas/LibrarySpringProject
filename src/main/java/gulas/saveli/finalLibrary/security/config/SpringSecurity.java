package gulas.saveli.finalLibrary.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SpringSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/admin").hasRole("ROLE_ADMIN")
                .requestMatchers("/user").hasRole("ROLE_USER")
                .requestMatchers("/").permitAll()
                .and().formLogin();
        return http.build();
    }
}
