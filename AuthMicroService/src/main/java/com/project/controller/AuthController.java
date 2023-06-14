package com.project.controller;

import com.project.dto.request.RegisterRequestDto;
import com.project.service.AuthService;
import lombok.RequiredArgsConstructor;
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
}
