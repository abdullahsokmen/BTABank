package com.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailsResponseDto {
    private Long id;
    private String customerName;
    private String customerLastname;
    private Long customerId;
    private Long accountNo;
    private Double balance;
    private Double creditDept;
}
