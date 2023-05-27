package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.btproject.traineeservice.entity.Application;
import ru.btproject.traineeservice.entity.Mentor;
import ru.btproject.traineeservice.repository.ApplicationRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public List<Application> getAll() {
        return applicationRepository.findAllWithAllData();
    }

    public List<Application> getAllActive() {
        return applicationRepository.findAllByIsActive(true);
    }

    public Application getByMentor(Mentor mentor) {
        return applicationRepository.findByCreatedByEquals(mentor);
    }
}
