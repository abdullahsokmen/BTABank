package com.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/authservice")
    public ResponseEntity<String>fallbackAuth(){
        return ResponseEntity.ok("Auth service is currently unavailable");
    }
    @GetMapping("/customerservice")
    public ResponseEntity<String>fallbackCustomer(){
        return ResponseEntity.ok("Customer service currently unavalible");
    }
    @GetMapping("/paymentservice")
    public ResponseEntity<String>fallbackPayment(){
        return ResponseEntity.ok("Payment service currently unavalible");
    }
    @GetMapping("/personalservice")
    public ResponseEntity<String>fallbackPersonal(){
        return ResponseEntity.ok("Personal service currently unavalible");
    }
    @GetMapping("/accountservice")
    public ResponseEntity<String>fallbackAccount(){
        return ResponseEntity.ok("Account service currently unavalible");
    }

}
