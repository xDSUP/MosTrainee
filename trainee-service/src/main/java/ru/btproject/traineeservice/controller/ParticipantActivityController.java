package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.entity.ParticActivityHist;
import ru.btproject.traineeservice.entity.Participant;
import ru.btproject.traineeservice.service.ParticipantActivityService;
import ru.btproject.traineeservice.service.ParticipantService;
import ru.btproject.traineeservice.service.StageSchedulerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participant/")
@AllArgsConstructor
public class ParticipantActivityController {

    private final StageSchedulerService stageSchedulerService;
    private final ParticipantActivityService participantActivityService;
    private final ParticipantService participantService;

    @GetMapping("/activity")
    public List<ParticActivityHist> getAll(){
        return participantActivityService.getAll();
    }


    @GetMapping("/{participantId}/activity")
    public List<ParticActivityHist> getAllByPartic(@RequestParam Long participantId){
        Optional<Participant> byParticId = participantService.getByParticId(participantId);
        return participantActivityService.getByPartic(byParticId.get());
    }
}
