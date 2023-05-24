package ru.btproject.traineeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "case_challange_info", indexes = {
        @Index(name = "case_challange_info_code_uindex", columnList = "code", unique = true)
})
public class CaseChallangeInfo implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Lob
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column(name = "link_to_ext_resource", nullable = false, columnDefinition = "TEXT")
    private String linkToExtResource;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "finished")
    private Boolean finished;

    public Boolean getFinished()
    {
        return finished;
    }

    public void setFinished(Boolean finished)
    {
        this.finished = finished;
    }

    public LocalTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public String getLinkToExtResource()
    {
        return linkToExtResource;
    }

    public void setLinkToExtResource(String linkToExtResource)
    {
        this.linkToExtResource = linkToExtResource;
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