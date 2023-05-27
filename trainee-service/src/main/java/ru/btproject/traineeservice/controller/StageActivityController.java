package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.entity.StageActivity;
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
    public List<StageActivity> getAll(){
        return stageActivityService.getAll();
    }

    @GetMapping("/current")
    public List<StageActivity> getForCurrentStage(){
        return stageActivityService.getForStage(stageSchedulerService.getCurrentStage());
    }
}
