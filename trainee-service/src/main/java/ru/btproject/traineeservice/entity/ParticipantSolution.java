package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;
import ru.btproject.traineeservice.service.ParticipantSolutionStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "participant_solutions", indexes = {
        @Index(name = "participant_solutions_appid_idx", columnList = "application_id"),
        @Index(name = "participant_solutions_pid_idx", columnList = "participant_id")
})
public class ParticipantSolution implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Column(name = "solution", nullable = false)
    private byte[] solution;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10)
    private ParticipantSolutionStatus status;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "score")
    private BigDecimal score;

    public BigDecimal getScore()
    {
        return score;
    }

    public void setScore(BigDecimal score)
    {
        this.score = score;
    }

    public LocalDate getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public byte[] getSolution()
    {
        return solution;
    }

    public void setSolution(byte[] solution)
    {
        this.solution = solution;
    }

    public Application getApplication()
    {
        return application;
    }

    public void setApplication(Application application)
    {
        this.application = application;
    }

    public Participant getParticipant()
    {
        return participant;
    }

    public void setParticipant(Participant participant)
    {
        this.participant = participant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParticipantSolutionStatus getStatus() {
        return status;
    }

    public void setStatus(ParticipantSolutionStatus status) {
        this.status = status;
    }
}