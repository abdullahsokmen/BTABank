package com.project.manager;

import com.project.dto.request.RegisterRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.constants.EndPoints.DELETE;
import static com.project.constants.EndPoints.SAVE;

@FeignClient(url = "http://localhost:9090/api/v1/auth",decode404 = true,name = "personal-auth")
public interface IAuthManager {
    @PostMapping(SAVE)
    public ResponseEntity<Long> register(@RequestBody RegisterRequestDto dto);

    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteByAuthId(@RequestParam Long id);
}
