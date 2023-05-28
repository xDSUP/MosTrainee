package ru.btproject.traineeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.dto.LoginRequest;
import ru.btproject.traineeservice.dto.LoginResponse;
import ru.btproject.traineeservice.repository.UserRepository;
import ru.btproject.traineeservice.service.JwtService;

@CrossOrigin
@RestController
public class LoginController
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        LoginResponse loginResponse = new LoginResponse(
                userDetails.getUsername(),
                jwtService.generateJwtHeaderFromUsername(userDetails.getUsername()),
                userRepository.findByUsername(loginRequest.getUsername()).get().getUserType()
        );

        return ResponseEntity.ok(loginResponse);
    }
}
