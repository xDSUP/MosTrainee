package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.btproject.traineeservice.entity.Mentor;
import ru.btproject.traineeservice.entity.User;
import ru.btproject.traineeservice.repository.MentorRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MentorService {
    private final MentorRepository repository;
    private final UserDetailsServiceImpl userDetailsService;

    public Optional<Mentor> getCurrentAuthorized() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.getUser(username);
        return repository.findById(user.getId());
    }
}
