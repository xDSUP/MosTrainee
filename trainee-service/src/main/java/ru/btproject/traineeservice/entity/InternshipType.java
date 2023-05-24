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
@Table(name = "internship_types")
public class InternshipType implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "internshipType")
    private Set<Participant> participants = new LinkedHashSet<>();

    @OneToMany(mappedBy = "internshipType")
    private Set<Application> applications = new LinkedHashSet<>();

    public Set<Application> getApplications()
    {
        return applications;
    }

    public void setApplications(Set<Application> applications)
    {
        this.applications = applications;
    }

    public Set<Participant> getParticipants()
    {
        return participants;
    }

    public void setParticipants(Set<Participant> participants)
    {
        this.participants = participants;
    }

    public Boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(Boolean isActive)
    {
        this.isActive = isActive;
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