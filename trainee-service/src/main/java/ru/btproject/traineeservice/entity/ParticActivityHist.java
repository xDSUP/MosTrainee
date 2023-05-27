package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "partic_activity_hist")
public class ParticActivityHist implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "activity_id")
    private Long activityId;

    @Column(name = "score", nullable = false)
    private BigDecimal score;

    
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    public Participant getParticipant()
    {
        return participant;
    }

    public void setParticipant(Participant participant)
    {
        this.participant = participant;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public BigDecimal getScore()
    {
        return score;
    }

    public void setScore(BigDecimal score)
    {
        this.score = score;
    }

    public Long getActivityId()
    {
        return activityId;
    }

    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
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