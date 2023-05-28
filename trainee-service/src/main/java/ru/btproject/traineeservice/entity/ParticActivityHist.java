package ru.btproject.traineeservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.btproject.traineeservice.utils.LazyFieldsFilter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "partic_activity_hist")
public class ParticActivityHist implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "score", nullable = false)
    private BigDecimal score;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false)
    private StageActivity stageActivity;
}