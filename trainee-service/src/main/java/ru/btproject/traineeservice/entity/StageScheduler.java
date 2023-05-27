package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stage_scheduler", indexes = {
        @Index(name = "stage_scheduler_id_uindex", columnList = "id", unique = true),
        @Index(name = "stage_scheduler_code_uindex", columnList = "code", unique = true)
})
public class StageScheduler implements Serializable
{
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "active", nullable = false)
    private Boolean active = false;
}