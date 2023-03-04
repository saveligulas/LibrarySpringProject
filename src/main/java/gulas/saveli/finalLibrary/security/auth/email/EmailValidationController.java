package gulas.saveli.finalLibrary.security.auth.email;

import gulas.saveli.finalLibrary.security.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/validator")
@RequiredArgsConstructor
public class EmailValidationController {

    @Autowired
    private final EmailValidationService emailValidationService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value="/email")
    @ResponseBody
    public String register (String email) {
        return emailValidationService.validateEmail(email);
    }
}
