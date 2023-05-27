package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "staff")
public class Staff implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
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

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Organization getOrganization()
    {
        return organization;
    }

    public void setOrganization(Organization organization)
    {
        this.organization = organization;
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