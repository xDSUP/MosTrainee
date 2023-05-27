package ru.btproject.traineeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.btproject.traineeservice.dto.*;
import ru.btproject.traineeservice.entity.Application;
import ru.btproject.traineeservice.service.ApplicationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    private static ListApplicationDto getListApplicationDto(Application application) {
        return ListApplicationDto.builder()
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
    public List<ListApplicationDto> getAll() { // для Куратора
        return applicationService.getAll().stream().map(
                ApplicationController::getListApplicationDto
        ).toList();
    }

    @GetMapping("/api/application/active")
    public List<ListApplicationDto> getAllActive() {
        return applicationService.getAllActive().stream().map(
                ApplicationController::getListApplicationDto
        ).toList();
    }
}
