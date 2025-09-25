package com.mvarone.appmeteo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Base64;

@Configuration
@ConfigurationProperties(prefix = "security.user")
public class SecurityConfig {

    private String name;     // corrisponde a security.user.name
    private String password; // corrisponde a security.user.password
    private String roles;    // corrisponde a security.user.roles

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRoles() { return roles; }
    public void setRoles(String roles) { this.roles = roles; }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        String decodedName = new String(Base64.getDecoder().decode(name));
        UserDetails user = User.withDefaultPasswordEncoder()
            .username(decodedName)
            .password(decodedPassword)
            .roles(roles)
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
