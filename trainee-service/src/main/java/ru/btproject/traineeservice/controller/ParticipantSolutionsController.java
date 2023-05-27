package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.dto.ApplicationMentorDto;
import ru.btproject.traineeservice.dto.OrganizationDto;
import ru.btproject.traineeservice.dto.ParticipantSolutionsDto;
import ru.btproject.traineeservice.entity.Application;
import ru.btproject.traineeservice.entity.Mentor;
import ru.btproject.traineeservice.entity.Participant;
import ru.btproject.traineeservice.service.ParticipantService;
import ru.btproject.traineeservice.service.ParticipantSolutionService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ParticipantSolutionsController {

    private final ParticipantService participantService;
    private final ParticipantSolutionService solutionService;


    @GetMapping("/api/participant/{participantId}/solution/") // для стажера
    public List<ParticipantSolutionsDto> getSolutions(@PathVariable Long participantId) {
        Optional<Participant> participantOptional = participantService.getByParticId(participantId);

        return participantOptional.map(participant -> solutionService.getByPartic(participant).stream().map(
                solution -> {
                    Application application = solution.getApplication();
                    Mentor mentor = application.getCreatedBy();

                    return ParticipantSolutionsDto.builder()
                            .id(solution.getId())
                            .status(solution.getStatus().name())
                            .vacancy(application.getName())
                            .organization(new OrganizationDto(mentor.getOrganization()))
                            .mentor(new ApplicationMentorDto(mentor))
                            .createdAt(solution.getCreatedAt())
                            .build();
                }
        ).toList()).orElse(Collections.emptyList());

    }

    @GetMapping("/api/participant/solution/") // для стажера
    public List<ParticipantSolutionsDto> getSolutions() {
        // получать текущего парсипанта
        return null;
    }

}
