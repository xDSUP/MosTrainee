package ru.btproject.traineeservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleParticipantDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String educationType;
    private String rating;
    private String status;
}
