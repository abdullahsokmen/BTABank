package com.project.controller;

import com.project.dto.request.CustomerSaveRequestDto;
import com.project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.constants.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean>saveCustomer(@RequestBody CustomerSaveRequestDto dto){
        return ResponseEntity.ok(customerService.saveCustomer(dto));

    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean>deleteCustomer(@RequestParam Long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }


}
