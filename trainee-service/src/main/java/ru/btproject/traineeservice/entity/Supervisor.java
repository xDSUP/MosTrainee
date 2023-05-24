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
@Table(name = "supervisors")
public class Supervisor implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Lob
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Lob
    @Column(name = "middle_name", columnDefinition = "TEXT")
    private String middleName;

    @Lob
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