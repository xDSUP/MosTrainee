package ru.btproject.traineeservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class ApplicationDto {
    private Long id;
    private String name;
    private String description;
    private String requirement;
    private String workTime;
    private String type;
    private ApplicationMentorDto mentor;
    private OrganizationDto organization;
    private InternshipTypeDto internshipType;
    private BranchDto branch;
    private LocalDate createdAt;
    private Boolean isActive;
    private Set<AttachmentDto> attachments;
}
