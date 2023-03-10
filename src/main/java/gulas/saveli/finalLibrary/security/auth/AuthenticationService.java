package gulas.saveli.finalLibrary.security.auth;

import gulas.saveli.finalLibrary.library.errorHandler.handler.ApiRequestException;
import gulas.saveli.finalLibrary.repo.UserRepository;
import gulas.saveli.finalLibrary.security.jwt.JwtService;
import gulas.saveli.finalLibrary.user.Role;
import gulas.saveli.finalLibrary.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public String register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isEmpty()) {
            var user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
            return "User registered successfully";
        } else {
            throw new ApiRequestException("User with email already exists");
        }

//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
    }

    public void registerAdmin(RegisterRequest user) {
        if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
            var admin = User.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(admin);
        } else {
            throw new ApiRequestException("User with email already exists");
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ApiRequestException("user with email " + request.getEmail() + " does not exist"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
