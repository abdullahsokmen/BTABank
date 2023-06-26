package com.project.controller;

import com.project.dto.request.CreateAccountRequestDto;
import com.project.dto.request.UpdateAccountRequestDto;
import com.project.dto.response.AccountDetailsResponseDto;
import com.project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.constants.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(ACCOUNT)
public class AccountController {
    private final AccountService accountService;


    @PostMapping(SAVE)
    public ResponseEntity<Boolean>createAccount(@RequestBody CreateAccountRequestDto dto){
        return ResponseEntity.ok(accountService.createAccount(dto));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<Boolean>updateAccount(@RequestBody UpdateAccountRequestDto dto){
        return ResponseEntity.ok(accountService.updateAccount(dto));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean>deleteAccount(@RequestParam Long id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }
    @PostMapping(BLOKE)
    public ResponseEntity<Boolean>blokeAccount(@RequestParam Long id){
        return ResponseEntity.ok(accountService.blokeAccount(id));
    }
    @GetMapping(GETACCOUNTDETAILS)
    public ResponseEntity<AccountDetailsResponseDto>getAccountDetails(@RequestParam Long id){
        return ResponseEntity.ok(accountService.getAccountDetails(id));
    }
}
