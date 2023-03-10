package gulas.saveli.finalLibrary.security.auth.email;

import gulas.saveli.finalLibrary.library.errorHandler.handler.ApiRequestException;
import lombok.SneakyThrows;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class EmailValidationService {

    public String validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean isValid = validator.isValid(email);
        if(!isValid) {
            throw new ApiRequestException("email is not valid");
        }
        return "email is valid";
    }
}
