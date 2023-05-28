package ru.btproject.traineeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.btproject.traineeservice.entity.UserType;

@Data
@AllArgsConstructor
public class LoginResponse
{
    private String username;
    private String token;
    private UserType userType;
}
