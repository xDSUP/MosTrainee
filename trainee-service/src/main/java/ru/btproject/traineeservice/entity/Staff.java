package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staff")
public class Staff implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    
    @Column(name = "middle_name", columnDefinition = "TEXT")
    private String middleName;

}