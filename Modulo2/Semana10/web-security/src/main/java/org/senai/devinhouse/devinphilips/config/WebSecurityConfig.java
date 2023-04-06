package org.senai.devinhouse.devinphilips.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout.logoutUrl("/logout"));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        UserDetails user1 =
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("1234"))
                        .roles("Admin")
                        .build();
        UserDetails user2 =
                User.builder()
                        .username("saull")
                        .password(passwordEncoder().encode("1234"))
                        .roles("Admin")
                        .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user1);
        users.createUser(user2);
        return users;
    }
}
