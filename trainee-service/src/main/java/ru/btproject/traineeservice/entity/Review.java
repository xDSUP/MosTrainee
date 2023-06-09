package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "reviews")
public class Review implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    
    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column(name = "score")
    private Integer score;

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Mentor getMentor()
    {
        return mentor;
    }

    public void setMentor(Mentor mentor)
    {
        this.mentor = mentor;
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