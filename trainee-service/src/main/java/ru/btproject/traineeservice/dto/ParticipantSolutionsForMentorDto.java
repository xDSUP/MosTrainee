package ru.btproject.traineeservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ParticipantSolutionsForMentorDto {
    private Long id;
    private String status;
    private SimpleParticipantDto participant;
    private BigDecimal score;
}
