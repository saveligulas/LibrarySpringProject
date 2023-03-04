package gulas.saveli.finalLibrary.security.auth.email;

import lombok.SneakyThrows;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class EmailValidationService {

    @SneakyThrows
    public String validateEmail(String email) {
        boolean isValid = EmailValidator.getInstance().isValid(email);
        if(!isValid) {
            throw new ValidatorException("email is not valid");
        }
        return "email is valid";
    }
}
