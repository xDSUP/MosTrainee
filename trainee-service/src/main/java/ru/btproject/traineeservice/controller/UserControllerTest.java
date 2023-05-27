package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.entity.User;
import ru.btproject.traineeservice.repository.UserRepository;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserControllerTest
{
    private final UserRepository userRepository;

    @GetMapping("/api/user/get-by-username")
    public User getUserByUsername(String username)
    {
        Optional<User> byUsername = userRepository.findByUsername("mentor1");
        return byUsername.get();
    }
}
