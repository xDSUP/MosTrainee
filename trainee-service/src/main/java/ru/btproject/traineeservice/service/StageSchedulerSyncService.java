package ru.btproject.traineeservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Slf4j
@ConditionalOnProperty(
        value = "app.stage_sync.enable", havingValue = "true", matchIfMissing = true
)
public class StageSchedulerSyncService {

    private final StageSchedulerService stageSchedulerService;

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "@daily")
    public void runAfterStartup() {
        LocalDate currentDay = LocalDate.now();
        stageSchedulerService.activateStageByDate(currentDay);
    }
}
