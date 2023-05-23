package com.project.service;

import com.project.dto.Request.CustomerCreateRequestDto;
import com.project.dto.Request.CustomerUpdateRequestDto;
import com.project.dto.Response.CustomerMinorDetailsResponseDto;
import com.project.dto.Response.GetCustomerDetailsResponseDto;
import com.project.exception.CustomerServiceException;
import com.project.exception.EErrorType;
import com.project.mapper.ICustomerMapper;
import com.project.repository.ICustomerRepository;
import com.project.repository.entity.Customer;
import com.project.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public Boolean createCustomer(CustomerCreateRequestDto dto) {
        Customer customer= ICustomerMapper.INSTANCE.toCustomer(dto);
        save(customer);
        return true;
    }

    public Boolean updateCustomer(CustomerUpdateRequestDto dto) {
        Optional<Customer>customer=findById(dto.getId());
        if (customer.isEmpty())
            throw new CustomerServiceException(EErrorType.CUSTOMER_NOT_EXIST);
        customer.get().setAge(dto.getAge());
        update(customer.get());
        return true;
    }

    public Boolean deleteCustomer(Long id) {
        Optional<Customer>customer=findById(id);
        if (customer.isEmpty())
            throw new CustomerServiceException(EErrorType.CUSTOMER_NOT_EXIST);
        return true;
    }

    public GetCustomerDetailsResponseDto getPersonalDetails(Long id) {
        Optional<Customer>customer=findById(id);
        if (customer.isEmpty())
            throw new CustomerServiceException(EErrorType.CUSTOMER_NOT_EXIST);
        GetCustomerDetailsResponseDto dto=ICustomerMapper.INSTANCE.toGetCustomerDetailsResponseDto(customer.get());
        return dto;
    }

    public List<CustomerMinorDetailsResponseDto> getAllPersonals() {
        return findAll().stream().map(x->ICustomerMapper.INSTANCE.fromCustomer(x)).toList();
    }
}
