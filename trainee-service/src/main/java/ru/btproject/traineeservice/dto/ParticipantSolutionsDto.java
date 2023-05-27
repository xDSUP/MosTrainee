package ru.btproject.traineeservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ParticipantSolutionsDto {
    private Long id;
    private String status;
    private String vacancy;
    private OrganizationDto organization;
    private ApplicationMentorDto mentor;
    private LocalDate createdAt;
}
