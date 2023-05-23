package com.project.service;

import com.project.dto.request.PersonalSaveRequestDto;
import com.project.mapper.IPersonalMapper;
import com.project.repository.IPersonalRepository;
import com.project.repository.entity.Personal;
import com.project.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PersonalService extends ServiceManager<Personal,Long> {
    private final IPersonalRepository personalRepository;

    public PersonalService(IPersonalRepository personalRepository) {
        super(personalRepository);
        this.personalRepository = personalRepository;
    }

    public Boolean savePersonal(PersonalSaveRequestDto dto) {
        Personal personal= IPersonalMapper.INSTANCE.toPersonal(dto);
        return true;
    }
}
