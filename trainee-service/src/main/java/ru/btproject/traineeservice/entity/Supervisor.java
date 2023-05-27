package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "supervisors")
public class Supervisor implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
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

    @OneToMany(mappedBy = "supervisor")
    private Set<Organization> organizations = new LinkedHashSet<>();

    public Set<Organization> getOrganizations()
    {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations)
    {
        this.organizations = organizations;
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}