package com.project.controller;

import com.project.dto.request.LoginRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.dto.response.LoginResponseDto;
import com.project.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.constants.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService authService;

    @PostMapping(SAVE)
    public ResponseEntity<Long>register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteByAuthId(@RequestParam Long id){
        return ResponseEntity.ok(authService.deleteByAuthId(id));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDto>login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }
}
