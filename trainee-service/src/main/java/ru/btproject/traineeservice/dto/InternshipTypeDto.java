package ru.btproject.traineeservice.dto;

import lombok.Getter;
import ru.btproject.traineeservice.entity.InternshipType;

@Getter
public class InternshipTypeDto {
    private Long id;
    private String code;
    private String description;

    public InternshipTypeDto(InternshipType internshipType) {
        id = internshipType.getId();
        code = internshipType.getCode();
        description = internshipType.getDescription();
    }
}
