package com.project.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerDetailsResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String identityNumber;
    private String customerNo;
    private int age;

}
