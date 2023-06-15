package com.project.controller;

import com.project.dto.request.PersonalSaveRequestDto;
import com.project.dto.request.PersonalUpdateRequestDto;
import com.project.dto.response.PersonalDetailsResponseDto;
import com.project.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.constants.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(PERSONAL)
public class PersonalController {
        private final PersonalService personalService;


        @PostMapping(SAVE)
        public ResponseEntity<Boolean>savePersonal(@RequestBody PersonalSaveRequestDto dto){
                return ResponseEntity.ok(personalService.savePersonal(dto));
        }
        @PutMapping(DELETE)
        public ResponseEntity<Boolean>deletePersonal(@RequestParam Long id){
                return ResponseEntity.ok(personalService.deletePersonalById(id));
        }
        @GetMapping(FINDALL)
        public ResponseEntity<List<PersonalDetailsResponseDto>>getPersonalList(){
                return ResponseEntity.ok(personalService.getAllPersonals());
        }
        @PutMapping(UPDATE)
        public ResponseEntity<Boolean>updatePersonal(@RequestBody PersonalUpdateRequestDto dto){
                return ResponseEntity.ok(personalService.updatePersonal(dto));
        }



}
