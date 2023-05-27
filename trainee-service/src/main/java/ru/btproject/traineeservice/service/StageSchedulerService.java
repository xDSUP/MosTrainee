package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.btproject.traineeservice.entity.StageScheduler;
import ru.btproject.traineeservice.repository.StageSchedulerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class StageSchedulerService {

    private final StageSchedulerRepository repository;

    public StageScheduler getCurrentStage() {
        return repository.findStageSchedulerByActive(true).orElseGet(
                () -> {
                    log.warn("Активного этапа не найдено");
                    return null;
                }
        );
    }

    public List<StageScheduler> getAllStages() {
        return repository.findAll();
    }

    public List<StageScheduler> getAllStagesForCandidate() {
        return repository.findAll().stream().filter(stage -> !stage.getCode().contains("INTERNSHIP_")).toList();
    }

    @Transactional
    public boolean activateStageByDate(LocalDate date) {
        log.info("Trying change current stage on date {}", date);
        Optional<StageScheduler> findedStage = repository.findStageSchedulerByStartDateBeforeAndEndDateAfter(date);
        StageScheduler stageScheduler = findedStage.orElseThrow(() -> new IllegalStateException("Not available stage for this date"));
        StageScheduler currentStage = getCurrentStage();
        if (currentStage != null) {
            if (currentStage.getStartDate().isBefore(date) && currentStage.getEndDate().isAfter(date)){
                log.info("Stage not changed for day {} current = {}", date, currentStage.getCode());
                return false;
            }
            currentStage.setActive(false);
            repository.save(currentStage);
            log.info("Deactivate old stage with code = {}", currentStage.getCode());
        }
        stageScheduler.setActive(true);
        repository.save(stageScheduler);
        log.info("Successful change current stage on {} by day {}", stageScheduler.getCode(), date);
        return true;
    }
}
