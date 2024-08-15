package ar.com.fcarmine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Deshabilitar la protección CSRF (opcional, solo si no usas formularios)
            .csrf().disable()
            
            // Permitir acceso sin autenticación a todos los endpoints
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
