package com.project.manager;

import com.project.dto.request.RegisterRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.project.constants.EndPoints.DELETE;
import static com.project.constants.EndPoints.SAVE;

@FeignClient(url = "http://localhost:9090/api/v1/auth",decode404 = true,name = "customer-auth")
public interface IAuthManager {
    @PostMapping(SAVE)
    public ResponseEntity<Long> register(@RequestBody RegisterRequestDto dto);

    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteByAuthId(@RequestParam Long id);
}
