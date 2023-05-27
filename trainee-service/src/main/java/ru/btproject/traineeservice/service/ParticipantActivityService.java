package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.btproject.traineeservice.entity.ParticActivityHist;
import ru.btproject.traineeservice.entity.Participant;
import ru.btproject.traineeservice.repository.ParticipantActivityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantActivityService {
    private final ParticipantActivityRepository repository;

    public List<ParticActivityHist> getAll(){
        return repository.findAll();
    }

    public List<ParticActivityHist> getByPartic(Participant participant) {
        return repository.findByParticipant(participant);
    }
}
