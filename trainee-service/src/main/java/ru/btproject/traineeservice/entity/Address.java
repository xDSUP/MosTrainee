package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    
    @Column(name = "city", nullable = false, columnDefinition = "TEXT")
    private String city;

    
    @Column(name = "street", nullable = false, columnDefinition = "TEXT")
    private String street;

    @Column(name = "building", nullable = false, length = 10)
    private String building;

    @Column(name = "flat", nullable = false, length = 10)
    private String flat;

    
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @OneToMany(mappedBy = "address")
    private Set<Participant> participants = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Branch> branches = new LinkedHashSet<>();

    public Set<Branch> getBranches()
    {
        return branches;
    }

    public void setBranches(Set<Branch> branches)
    {
        this.branches = branches;
    }

    public Set<Participant> getParticipants()
    {
        return participants;
    }

    public void setParticipants(Set<Participant> participants)
    {
        this.participants = participants;
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

    public String getFlat()
    {
        return flat;
    }

    public void setFlat(String flat)
    {
        this.flat = flat;
    }

    public String getBuilding()
    {
        return building;
    }

    public void setBuilding(String building)
    {
        this.building = building;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
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