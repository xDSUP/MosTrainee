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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supervisors")
public class Supervisor implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;


    @Column(name = "middle_name", columnDefinition = "TEXT")
    private String middleName;


    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = LazyFieldsFilter.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supervisor")
    private Set<Organization> organizations = new LinkedHashSet<>();
}