package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.entity.Participant;
import ru.btproject.traineeservice.service.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("/api/participant")
@AllArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping("/all")
    public List<Participant> getAll() {
        return participantService.getAll();
    }
}
