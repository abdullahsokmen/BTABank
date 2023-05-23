package com.project.controller;

import com.project.dto.request.PersonalSaveRequestDto;
import com.project.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
