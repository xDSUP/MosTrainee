package ru.btproject.traineeservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ParticActivityDto {
    private Long id;
    private Long activityId;
    private BigDecimal score;
    private String comment;
}
