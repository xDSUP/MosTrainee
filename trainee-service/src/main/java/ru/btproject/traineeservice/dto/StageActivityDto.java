package ru.btproject.traineeservice.dto;

import lombok.Builder;
import lombok.Data;
import ru.btproject.traineeservice.entity.ActivityType;
import ru.btproject.traineeservice.entity.StageActivity;

import java.time.LocalDateTime;

@Data
@Builder
public class StageActivityDto {
    private Long id;
    private Long stageId;
    private String code;
    private String description;
    private String linkToExtResource;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private ActivityType activityType;

    public StageActivityDto(StageActivity activity) {
        id = activity.getId();
        stageId = activity.getStage().getId();
        code = activity.getCode();
        description = activity.getDescription();
        linkToExtResource = activity.getLinkToExtResource();
        startDateTime = activity.getStartDateTime();
        endDateTime = activity.getEndDateTime();
        activityType = activity.getActivityType();
    }
}
