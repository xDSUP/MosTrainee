package ru.btproject.traineeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.dto.LoginRequest;
import ru.btproject.traineeservice.dto.LoginResponse;

@RestController
public class LoginController
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        if (authentication.isAuthenticated())
        {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage("login success");
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        }

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("login failed");
        return new ResponseEntity<>(loginResponse, HttpStatus.UNAUTHORIZED);
    }
}
