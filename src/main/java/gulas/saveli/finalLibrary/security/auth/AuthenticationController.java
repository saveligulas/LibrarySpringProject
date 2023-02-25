package gulas.saveli.finalLibrary.security.auth;

import gulas.saveli.finalLibrary.library.controller.builder.ThymeleafModelAndViewBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final ThymeleafModelAndViewBuilder thymeleafModelAndViewBuilder;

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return thymeleafModelAndViewBuilder.build("register");
    }

    @GetMapping("/authenticate")
    public ModelAndView loginPage() {
        return thymeleafModelAndViewBuilder.build("authenticate");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register (
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok((service.authenticate(request)));
    }
}
