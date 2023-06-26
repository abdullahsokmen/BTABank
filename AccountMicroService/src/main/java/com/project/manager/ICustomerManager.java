package com.project.manager;

import com.project.dto.response.CustomerInfoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.project.constants.EndPoints.CUSTOMERINFO;

@FeignClient(url = "http://localhost:9092/api/v1/customer",decode404 = true,name = "account-customer")
public interface ICustomerManager {
    @PostMapping(CUSTOMERINFO)
    public ResponseEntity<CustomerInfoResponseDto> getCustomerInfo(@RequestParam Long id);
}
