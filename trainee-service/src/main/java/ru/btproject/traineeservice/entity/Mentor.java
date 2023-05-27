package ru.btproject.traineeservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.btproject.traineeservice.utils.LazyFieldsFilter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mentors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mentor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;


    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;


    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    
    @Column(name = "middle_name", columnDefinition = "TEXT")
    private String middleName;

    
    @Column(name = "position", nullable = false, columnDefinition = "TEXT")
    private String position;


    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "is_qualified")
    private Boolean isQualified;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mentor")
    private Set<Review> reviews = new LinkedHashSet<>();

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mentor")
    private Set<LinkTagsToMentor> linkTagsToMentors = new LinkedHashSet<>();
}