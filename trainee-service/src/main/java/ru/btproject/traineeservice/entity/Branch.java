package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "branches")
public class Branch implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    
    @Column(name = "info", columnDefinition = "TEXT")
    private String info;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "branch")
    private Set<Application> applications = new LinkedHashSet<>();

    public Set<Application> getApplications()
    {
        return applications;
    }

    public void setApplications(Set<Application> applications)
    {
        this.applications = applications;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}