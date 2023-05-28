package ru.btproject.traineeservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.btproject.traineeservice.utils.LazyFieldsFilter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "internship_types")
public class InternshipType implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "internshipType")
    private Set<Participant> participants = new LinkedHashSet<>();

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "internshipType")
    private Set<Application> applications = new LinkedHashSet<>();
}