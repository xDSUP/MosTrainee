package ru.btproject.traineeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.btproject.traineeservice.entity.StageActivity;
import ru.btproject.traineeservice.entity.StageScheduler;

import java.util.List;

public interface StageActivityRepository extends JpaRepository<StageActivity, Long> {
    List<StageActivity> findAllByStage(StageScheduler stageScheduler);
}
