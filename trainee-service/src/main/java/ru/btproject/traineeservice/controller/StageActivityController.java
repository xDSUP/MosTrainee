package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.dto.StageActivityDto;
import ru.btproject.traineeservice.service.StageActivityService;
import ru.btproject.traineeservice.service.StageSchedulerService;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
@AllArgsConstructor
public class StageActivityController {
    private final StageActivityService stageActivityService;
    private final StageSchedulerService stageSchedulerService;

    @GetMapping("/all")
    public List<StageActivityDto> getAll() {
        return stageActivityService.getAll().stream().map(StageActivityDto::new).toList();
    }

    @GetMapping("/current")
    public List<StageActivityDto> getForCurrentStage() {
        return stageActivityService.getForStage(stageSchedulerService.getCurrentStage())
                .stream().map(StageActivityDto::new).toList();
    }
}
