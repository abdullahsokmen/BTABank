package com.project.service;

import com.project.dto.request.CustomerSaveRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.manager.IAuthManager;
import com.project.mapper.ICustomerMapper;
import com.project.repository.ICustomerRepository;
import com.project.repository.entity.Customer;
import com.project.utility.Generator;
import com.project.utility.ServiceManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {
    private final ICustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final IAuthManager authManager;

    public CustomerService(ICustomerRepository customerRepository, PasswordEncoder passwordEncoder, IAuthManager authManager) {
        super(customerRepository);
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
    }

    public Boolean saveCustomer(CustomerSaveRequestDto dto) {
        Customer customer= ICustomerMapper.INSTANCE.toCustomer(dto);
        String password= Generator.randomPassword();
        customer.setPassword(password);
        RegisterRequestDto register=ICustomerMapper.INSTANCE.toRegisterRequestDto(customer);
        register.setUserRole("CUSTOMER");
        register.setPassword(password);
        Long authId=authManager.register(register).getBody();
        customer.setAuthId(authId);
        save(customer);
        return true;
    }
}
