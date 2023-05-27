package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "participant_experience", indexes = {
        @Index(name = "participant_experience_pid_idx", columnList = "participant_id")
})
public class ParticipantExperience implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    
    @Column(name = "work_name", nullable = false, columnDefinition = "TEXT")
    private String workName;

    @Column(name = "work_type", nullable = false, length = 20)
    private String workType;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public String getWorkType()
    {
        return workType;
    }

    public void setWorkType(String workType)
    {
        this.workType = workType;
    }

    public String getWorkName()
    {
        return workName;
    }

    public void setWorkName(String workName)
    {
        this.workName = workName;
    }

    public Participant getParticipant()
    {
        return participant;
    }

    public void setParticipant(Participant participant)
    {
        this.participant = participant;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}