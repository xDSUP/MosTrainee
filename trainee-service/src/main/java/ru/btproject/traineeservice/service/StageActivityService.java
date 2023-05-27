package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.btproject.traineeservice.entity.StageActivity;
import ru.btproject.traineeservice.entity.StageScheduler;
import ru.btproject.traineeservice.repository.StageActivityRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class StageActivityService {

    private final StageActivityRepository activityRepository;

    public List<StageActivity> getAll() {
        return activityRepository.findAll();
    }

    public List<StageActivity> getForStage(StageScheduler stage) {
        return activityRepository.findAllByStage(stage);
    }
}
