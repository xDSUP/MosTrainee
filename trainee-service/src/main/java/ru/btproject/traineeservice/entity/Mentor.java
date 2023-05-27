package ru.btproject.traineeservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mentors")
public class Mentor implements Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
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

    @OneToMany(mappedBy = "mentor")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "mentor")
    private Set<LinkTagsToMentor> linkTagsToMentors = new LinkedHashSet<>();

    public Set<LinkTagsToMentor> getLinkTagsToMentors()
    {
        return linkTagsToMentors;
    }

    public void setLinkTagsToMentors(Set<LinkTagsToMentor> linkTagsToMentors)
    {
        this.linkTagsToMentors = linkTagsToMentors;
    }

    public Set<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews(Set<Review> reviews)
    {
        this.reviews = reviews;
    }

    public Boolean getIsQualified()
    {
        return isQualified;
    }

    public void setIsQualified(Boolean isQualified)
    {
        this.isQualified = isQualified;
    }

    public Double getRating()
    {
        return rating;
    }

    public void setRating(Double rating)
    {
        this.rating = rating;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
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