package com.project.service;

import com.project.dto.request.RegisterRequestDto;
import com.project.mapper.IAuthMapper;
import com.project.repository.IAuthRepository;
import com.project.repository.entity.Auth;
import com.project.repository.entity.ERole;
import com.project.utility.ServiceManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(IAuthRepository authRepository, PasswordEncoder passwordEncoder) {
        super(authRepository);
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Long register(RegisterRequestDto dto) {
        Auth auth= IAuthMapper.INSTANCE.toAuth(dto);
        auth.setPassword(dto.getPassword());
        auth.setRole(ERole.valueOf(dto.getUserRole()));
        save(auth);
        return auth.getId();
    }
}
