package ru.btproject.traineeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StageSchedulerDto {
    private Long id;
    private String code;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;
}
