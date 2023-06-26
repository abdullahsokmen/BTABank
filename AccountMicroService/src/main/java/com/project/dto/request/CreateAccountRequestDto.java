package com.project.dto.request;

import com.project.repository.enums.EAccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequestDto {
    private String customerName;
    private String customerLastname;
    private Long customerId;
    private String accountType;
    private String currency;
}
