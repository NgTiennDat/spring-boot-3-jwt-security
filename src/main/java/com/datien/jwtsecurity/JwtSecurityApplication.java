package com.datien.jwtsecurity;

import com.datien.jwtsecurity.auth.AuthenticationService;
import com.datien.jwtsecurity.auth.model.RegistrationRequest;
import com.datien.jwtsecurity.user.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegistrationRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@admin.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegistrationRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@manager.com")
                    .password("password")
                    .role(Role.MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());
        };
    }
}
