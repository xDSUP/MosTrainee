package ru.btproject.traineeservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.btproject.traineeservice.utils.LazyFieldsFilter;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "participant")
public class Participant implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "middle_name")
    private String middleName;

    @Basic
    @Column(name = "birth_date")
    private Date birthDate;

    @Basic
    @Column(name = "nationality")
    private String nationality;

    @Basic
    @Column(name = "citizenship")
    private String citizenship;

    @Basic
    @Column(name = "rating")
    private BigInteger rating;

    @Basic
    @Column(name = "education_type")
    private String educationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ParticipantStatus status;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "internship_id")
    private InternshipType internshipType;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
