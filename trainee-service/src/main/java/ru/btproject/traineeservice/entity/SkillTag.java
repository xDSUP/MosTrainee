package ru.btproject.traineeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "skill_tags")
public class SkillTag implements Serializable
{
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code", length = 20)
    private String code;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "skillTag")
    private Set<LinkTagsToMentor> linkTagsToMentors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "skillTag")
    private Set<LinkTagsToPartic> linkTagsToPartics = new LinkedHashSet<>();

    public Set<LinkTagsToPartic> getLinkTagsToPartics()
    {
        return linkTagsToPartics;
    }

    public void setLinkTagsToPartics(Set<LinkTagsToPartic> linkTagsToPartics)
    {
        this.linkTagsToPartics = linkTagsToPartics;
    }

    public Set<LinkTagsToMentor> getLinkTagsToMentors()
    {
        return linkTagsToMentors;
    }

    public void setLinkTagsToMentors(Set<LinkTagsToMentor> linkTagsToMentors)
    {
        this.linkTagsToMentors = linkTagsToMentors;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
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