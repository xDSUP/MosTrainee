package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.dto.*;
import ru.btproject.traineeservice.entity.Application;
import ru.btproject.traineeservice.entity.Mentor;
import ru.btproject.traineeservice.entity.ParticipantSolution;
import ru.btproject.traineeservice.service.ApplicationService;
import ru.btproject.traineeservice.service.MentorService;
import ru.btproject.traineeservice.service.ParticipantSolutionService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ParticipantSolutionService participantSolutionService;
    private final MentorService mentorService;

    private static ApplicationDto getListApplicationDto(Application application) {
        return ApplicationDto.builder()
                .id(application.getId())
                .name(application.getName())
                .description(application.getDescription())
                .requirement(application.getRequirement())
                .workTime(application.getWorkTime())
                .type(application.getType())
                .mentor(new ApplicationMentorDto(application.getCreatedBy()))
                .organization(new OrganizationDto(application.getCreatedBy().getOrganization()))
                .internshipType(new InternshipTypeDto(application.getInternshipType()))
                .branch(new BranchDto(application.getBranch()))
                .createdAt(application.getCreatedAt())
                .attachments(application.getAttachments().stream()
                        .map(file -> new AttachmentDto(file.getId(), file.getName()))
                        .collect(Collectors.toSet())
                )
                .isActive(application.getIsActive())
                .build();
    }

    @GetMapping("/api/application/all")
    public List<ApplicationDto> getAll() { // для Куратора
        return applicationService.getAll().stream().map(
                ApplicationController::getListApplicationDto
        ).toList();
    }

    @GetMapping("/api/application/for-current-mentor")
    public ApplicationDto getGetForCurrentMentor() { // для Куратора

        Mentor mentor = mentorService.getCurrentAuthorized().get();
        Application application = applicationService.getByMentor(mentor);
        return getListApplicationDto(application);
    }

    @GetMapping("/api/application/active")
    public List<ApplicationDto> getAllActive() {
        return applicationService.getAllActive().stream().map(
                ApplicationController::getListApplicationDto
        ).toList();
    }

    @GetMapping("/api/application/solutions/")
    public List<ParticipantSolutionsForMentorDto> getParticipantSolutionsForApplication() {
        return mentorService.getCurrentAuthorized().map(mentor -> {
                    Application application = applicationService.getByMentor(mentor);
                    List<ParticipantSolution> solutions = participantSolutionService.getByApplication(application);
                    return solutions.stream().map(solution -> ParticipantSolutionsForMentorDto.builder()
                            .id(solution.getId())
                            .status(solution.getStatus().name())
                            .score(solution.getScore())
                            .participant(SimpleParticipantDto.builder()
                                    .id(solution.getParticipant().getId())
                                    .firstName(solution.getParticipant().getFirstName())
                                    .lastName(solution.getParticipant().getLastName())
                                    .middleName(solution.getParticipant().getMiddleName())
                                    .build())
                            .build()).toList();
                })
                .orElse(Collections.emptyList());
    }
}
