package fr.m1sdv.bestioles.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {auth
                .requestMatchers("/rest/admin").hasRole("ADMIN")
                .requestMatchers("/rest/v1/**"). hasAnyRole("ADMIN", "USER")
                .requestMatchers("/rest/**").hasRole("USER");
//permettre à tout le monde d'accéder à l'URL racine
//auth.requestMatchers("/*").permitAll();
//Permettre à tout le monde d’accéder aux ressources statiques (img, css, …)
//auth.requestMatchers("/css/*").permitAll();
//auth.requestMatchers("/images/*").permitAll();
//Toutes autres url et méthodes HTTP ne sont pas permises
            auth.anyRequest().denyAll();
        });
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails userAdmin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN", "USER")
                .build();
        UserDetails user = User.builder()
                .username("elessiah")
                .password(passwordEncoder().encode("user123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, userAdmin);
    }
}
