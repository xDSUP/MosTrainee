package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
@AllArgsConstructor
public class ParticipantActivityController {

    private final StageSchedulerService stageSchedulerService;
    private final ParticipantActivityService participantActivityService;
    private final ParticipantService participantService;

    @GetMapping("/api/participant//activity")
    public List<ParticActivityHist> getAll() {
        return participantActivityService.getAll();
    }


    @GetMapping("/api/participant/{participantId}/activity")
    public List<ParticActivityHist> getAllByPartic(@RequestParam Long participantId) {
        Optional<Participant> byParticId = participantService.getByParticId(participantId);
        return participantActivityService.getByPartic(byParticId.get());
    }

    @GetMapping("/api/participant/my-activity")
    public List<ParticActivityHist> getAllByCurrentPartic() {
        Optional<Participant> byParticId = participantService.getCurrentAuthorized();
        return participantActivityService.getByPartic(byParticId.get());
    }
}
