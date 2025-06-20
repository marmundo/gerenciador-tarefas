package br.com.damasceno.gerenciador_tarefas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/tarefas/**").authenticated() // Protege os endpoints da API
                        .anyRequest().permitAll() // Permite acesso a outros endpoints
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> {
                        }) // Configura o uso de JWT para autenticação (lambda-based, no custom config)
                );
        return http.build();
    }
}