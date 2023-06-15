package com.project.service;

import com.project.dto.request.PersonalSaveRequestDto;
import com.project.dto.request.PersonalUpdateRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.dto.response.PersonalDetailsResponseDto;
import com.project.exception.EErrorType;
import com.project.exception.PersonalServiceException;
import com.project.manager.IAuthManager;
import com.project.mapper.IAddressMapper;
import com.project.mapper.IPersonalMapper;
import com.project.repository.IPersonalRepository;
import com.project.repository.entity.Address;
import com.project.repository.entity.Personal;
import com.project.utility.Generator;
import com.project.utility.ServiceManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService extends ServiceManager<Personal,Long> {
    private final IPersonalRepository personalRepository;
    private final IAuthManager authManager;
    private final PasswordEncoder passwordEncoder;

    public PersonalService(IPersonalRepository personalRepository, IAuthManager authManager, PasswordEncoder passwordEncoder) {
        super(personalRepository);
        this.personalRepository = personalRepository;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
    }

    public Boolean savePersonal(PersonalSaveRequestDto dto) {
        Personal personal= IPersonalMapper.INSTANCE.toPersonal(dto);
        personal.setAddress(IAddressMapper.INSTANCE.toAddress(dto.getAddress()));
        String password= Generator.randomPassword();
        personal.setPassword(password);
        RegisterRequestDto register=IPersonalMapper.INSTANCE.toRegisterRequestDto(personal);
        register.setUserRole("PERSONAL");
        register.setPassword(password);
        Long authId=authManager.register(register).getBody();
        personal.setAuthId(authId);
        save(personal);
        return true;
    }

    public Boolean deletePersonalById(Long id) {
        Optional<Personal>personal=findById(id);
        if (personal.isEmpty())
            throw new PersonalServiceException(EErrorType.PERSONAL_NOT_EXIST);
        deleteById(id);
        authManager.deleteByAuthId(personal.get().getAuthId());
        return true;
    }

    public List<PersonalDetailsResponseDto> getAllPersonals() {
        return findAll().stream().map(x->IPersonalMapper.INSTANCE.fromPersonal(x)).toList();
    }

    public Boolean updatePersonal(PersonalUpdateRequestDto dto) {
        Optional<Personal>personal=findById(dto.getId());
        if (personal.isEmpty())
            throw new PersonalServiceException(EErrorType.PERSONAL_NOT_EXIST);
        Personal toUpdate=personal.get();
        Address newAddress=IAddressMapper.INSTANCE.toAddress(dto.getAddress());
        toUpdate.setName(dto.getName());
        toUpdate.setSurname(dto.getSurname());
        toUpdate.setEmail(dto.getEmail());
        toUpdate.setPersonalNo(dto.getPersonalNo());
        toUpdate.setPhone(dto.getPhone());
        toUpdate.setIdentityNumber(dto.getIdentityNumber());
        update(toUpdate);
        return true;
    }
}
