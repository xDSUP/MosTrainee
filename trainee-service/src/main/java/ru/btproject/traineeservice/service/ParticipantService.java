package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.btproject.traineeservice.entity.Participant;
import ru.btproject.traineeservice.entity.User;
import ru.btproject.traineeservice.repository.ParticipantRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ParticipantService {
    private final ParticipantRepository repository;
    private final UserDetailsServiceImpl userDetailsService;

    public List<Participant> getAll() {
        return repository.findAll();
    }

    public Optional<Participant> getCurrentAuthorized() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.getUser(username);
        return repository.findById(user.getId());
    }

    public Optional<Participant> getByParticId(Long participantId) {
        Optional<Participant> participantOptional = repository.findById(participantId);
        if (participantOptional.isEmpty())
            log.warn("Participant with id {} not found!", participantId);
        return participantOptional;
    }
}
