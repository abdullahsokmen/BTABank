package com.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonalSaveRequestDto {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String identityNumber;
    private AddressCreateRequestDto address;
}
