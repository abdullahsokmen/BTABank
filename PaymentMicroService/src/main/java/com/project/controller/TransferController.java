package com.project.controller;

import com.project.dto.request.CreateTransferRequestDto;
import com.project.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.project.constants.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(TRANSFER)
public class TransferController {
    private final TransferService transferService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean>requestTransfer(@RequestBody CreateTransferRequestDto dto){
        return ResponseEntity.ok(transferService.requestTransfer(dto));
    }
}
