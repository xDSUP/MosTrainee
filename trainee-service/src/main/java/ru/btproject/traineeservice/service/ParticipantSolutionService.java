package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.btproject.traineeservice.entity.Application;
import ru.btproject.traineeservice.entity.Participant;
import ru.btproject.traineeservice.entity.ParticipantSolution;
import ru.btproject.traineeservice.repository.ParticipantSolutionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantSolutionService {
    private final ParticipantSolutionRepository repository;

    public List<ParticipantSolution> getAll() {
        return repository.findAll();
    }

    public List<ParticipantSolution> getByPartic(Participant participant) {
        return repository.findByPartic(participant);
    }

    public List<ParticipantSolution> getByApplication(Application application) {
        return repository.findByApplication(application);
    }
}
