package com.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDetailsResponseDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
}
