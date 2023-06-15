package com.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonalUpdateRequestDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String personalNo;
    private String phone;
    private String identityNumber;
    private AddressCreateRequestDto address;
}
