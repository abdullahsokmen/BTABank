package com.project.controller;

import com.project.dto.request.CreateCreditPaymentRequestDto;
import com.project.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.project.constants.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(CREDIT)
public class CreditController {
    private final CreditService creditService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean>requestCredit(@RequestBody CreateCreditPaymentRequestDto dto){
        return ResponseEntity.ok(creditService.requestCreditPayment(dto));
    }
}
