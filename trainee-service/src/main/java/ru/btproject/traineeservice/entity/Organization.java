package ru.btproject.traineeservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import ru.btproject.traineeservice.utils.LazyFieldsFilter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;


    @Column(name = "info", columnDefinition = "TEXT")
    private String info;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    private Set<Mentor> mentors = new LinkedHashSet<>();

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    private Set<Staff> staff = new LinkedHashSet<>();

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }

    public Set<Mentor> getMentors()
    {
        return mentors;
    }

    public void setMentors(Set<Mentor> mentors)
    {
        this.mentors = mentors;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Supervisor getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor)
    {
        this.supervisor = supervisor;
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