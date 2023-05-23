package com.project.controller;

import com.project.dto.Request.CustomerCreateRequestDto;
import com.project.dto.Request.CustomerUpdateRequestDto;
import com.project.dto.Response.CustomerMinorDetailsResponseDto;
import com.project.dto.Response.GetCustomerDetailsResponseDto;
import com.project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.constants.EndPoints.*;
@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping(SAVE)
    public ResponseEntity<Boolean>createCustomer(@RequestBody CustomerCreateRequestDto dto){
        return ResponseEntity.ok(customerService.createCustomer(dto));
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Boolean>updateCustomer(@RequestBody CustomerUpdateRequestDto dto){
        return ResponseEntity.ok(customerService.updateCustomer(dto));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean>deleteCustomer(@RequestParam Long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
    @GetMapping(GETCUSTOMERDETAILS)
    public ResponseEntity<GetCustomerDetailsResponseDto>getPersonalDetails(@RequestParam Long id){
        return ResponseEntity.ok(customerService.getPersonalDetails(id));
    }
    @GetMapping(GETALLCUSTOMERS)
    public ResponseEntity<List<CustomerMinorDetailsResponseDto>>getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllPersonals());
    }

}
