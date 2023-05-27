package ru.btproject.traineeservice.dto;

import lombok.Getter;
import ru.btproject.traineeservice.entity.Mentor;

import java.io.Serializable;

@Getter
public class ApplicationMentorDto implements Serializable {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private Double rating;

    public ApplicationMentorDto(Mentor mentor) {
        id = mentor.getId();
        lastName = mentor.getLastName();
        firstName = mentor.getFirstName();
        middleName = mentor.getMiddleName();
        position = mentor.getPosition();
        rating = mentor.getRating();
    }
}
