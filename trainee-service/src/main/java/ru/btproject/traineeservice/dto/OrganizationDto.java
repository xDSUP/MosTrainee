package ru.btproject.traineeservice.dto;

import lombok.Getter;
import ru.btproject.traineeservice.entity.Organization;

@Getter
public class OrganizationDto {
    private Long id;
    private String name;
    private String info;

    public OrganizationDto(Organization organization) {
        id = organization.getId();
        name = organization.getName();
        info = organization.getInfo();
    }
}
