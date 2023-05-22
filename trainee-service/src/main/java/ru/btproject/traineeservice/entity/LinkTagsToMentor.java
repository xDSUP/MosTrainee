package ru.btproject.traineeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "link_tags_to_mentor")
public class LinkTagsToMentor implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_tag_id", nullable = false, referencedColumnName = "id")
    private SkillTag skillTag;

    public SkillTag getSkillTag()
    {
        return skillTag;
    }

    public void setSkillTag(SkillTag skillTag)
    {
        this.skillTag = skillTag;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Mentor getMentor()
    {
        return mentor;
    }

    public void setMentor(Mentor mentor)
    {
        this.mentor = mentor;
    }

}