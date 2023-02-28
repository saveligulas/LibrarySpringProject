package gulas.saveli.finalLibrary.security.auth;

import gulas.saveli.finalLibrary.library.controller.builder.ThymeleafModelAndViewBuilder;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationService service;
    @Autowired
    private final ThymeleafModelAndViewBuilder thymeleafModelAndViewBuilder;

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return thymeleafModelAndViewBuilder.build("register");
    }

    @GetMapping("/authenticate")
    public ModelAndView loginPage() {
        return thymeleafModelAndViewBuilder.build("authenticate");
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value="/post/register")
    @ResponseBody
    public ResponseEntity<String> register (
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

//    public HttpServletResponse authenticateTest(@RequestBody AuthenticationRequest request) {
//        Cookie jwtCookie = new Cookie("user-id", service.authenticate(request).getToken());
//        return new HttpServletResponse().addCookie(jwtCookie);
//    }

    @PostMapping("/post/authenticate")
    @ResponseBody
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok((service.authenticate(request)));
    }
}
