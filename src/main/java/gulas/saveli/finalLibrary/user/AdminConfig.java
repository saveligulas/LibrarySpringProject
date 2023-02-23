package gulas.saveli.finalLibrary.user;

import gulas.saveli.finalLibrary.security.auth.AuthenticationService;
import gulas.saveli.finalLibrary.security.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AdminConfig {

    @Autowired
    private final AuthenticationService authenticationService;

    @Bean
    public CommandLineRunner commandLineRunner() {
        RegisterRequest admin = new RegisterRequest(
                "Saveli",
                "Gulas",
                "saveli.gulas@gmail.com",
                "T7tfrMn6DD28H9R7"
        );
        return args ->
                authenticationService.registerAdmin(admin);
    }
}
