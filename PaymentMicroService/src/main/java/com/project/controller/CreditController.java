package com.project.controller;

import com.project.dto.request.CreateCreditPaymentRequestDto;
import com.project.dto.request.UpdateCreditPaymentRequestDto;
import com.project.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping(UPDATE)
    public ResponseEntity<Boolean>updateCredit(@RequestBody UpdateCreditPaymentRequestDto dto){
        return ResponseEntity.ok(creditService.updateCreditPayment(dto));
    }
}
