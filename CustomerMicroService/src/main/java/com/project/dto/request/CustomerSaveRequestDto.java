package com.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequestDto {
    private String name;
    private String surname;
    private Date birthDate;
    private String birthPlace;
    private String identity;
    private String email;
    private AddressCreateRequestDto address;
}
