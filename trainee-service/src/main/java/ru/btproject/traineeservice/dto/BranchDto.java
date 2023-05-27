package ru.btproject.traineeservice.dto;

import lombok.Getter;
import ru.btproject.traineeservice.entity.Branch;

@Getter
public class BranchDto {
    private Long id;
    private String name;
    private String info;

    public BranchDto(Branch branch) {
        id = branch.getId();
        name = branch.getName();
        info = branch.getInfo();
    }
}
