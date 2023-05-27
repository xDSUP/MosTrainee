package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.entity.StageScheduler;
import ru.btproject.traineeservice.service.StageSchedulerService;

import java.util.List;

@RestController
@RequestMapping("/api/stage-schedule/")
@AllArgsConstructor
public class StageScheduleController {

    private final StageSchedulerService stageSchedulerService;

    @GetMapping("/all")
    public List<StageScheduler> getAll(){
        return stageSchedulerService.getAllStages();
    }

    @GetMapping("/current")
    public StageScheduler getCurrentStage(){
        return stageSchedulerService.getCurrentStage();
    }

    @GetMapping("/candidate")
    public List<StageScheduler> getAllByCandidate(){
        return stageSchedulerService.getAllStagesForCandidate();
    }
}
