package com.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCreditPaymentRequestDto {
    private Long id;
    private Double amount;
    private String creditDetails;
    private String expiry;
}
