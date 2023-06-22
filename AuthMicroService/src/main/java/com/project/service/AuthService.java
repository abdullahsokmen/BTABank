package com.project.service;

import com.project.dto.request.LoginRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.dto.response.LoginResponseDto;
import com.project.exception.AuthServiceException;
import com.project.exception.EErrorType;
import com.project.mapper.IAuthMapper;
import com.project.repository.IAuthRepository;
import com.project.repository.entity.Auth;
import com.project.repository.entity.ERole;
import com.project.utility.JwtTokenManager;
import com.project.utility.ServiceManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenManager jwtTokenManager;

    public AuthService(IAuthRepository authRepository, PasswordEncoder passwordEncoder, JwtTokenManager jwtTokenManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenManager = jwtTokenManager;
    }

    public Long register(RegisterRequestDto dto) {
        Auth auth= IAuthMapper.INSTANCE.toAuth(dto);
        auth.setPassword(dto.getPassword());
        auth.setRole(ERole.valueOf(dto.getUserRole()));
        save(auth);
        return auth.getId();
    }

    public Boolean deleteByAuthId(Long id) {
        Optional<Auth>auth=findById(id);
        if (auth.isEmpty())
            throw new AuthServiceException(EErrorType.USER_NOT_FOUND);
        deleteById(id);
        return true;
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<Auth>optionalAuth=authRepository.findByEmail(dto.getEmail());
        if (optionalAuth.isEmpty() || passwordEncoder.matches(dto.getPassword(),optionalAuth.get().getPassword()))
            throw new AuthServiceException(EErrorType.LOGIN_ERROR_USERNAME_PASSWORD);
        Auth auth=optionalAuth.get();
        Optional<String>token=jwtTokenManager.createToken(auth.getId(),auth.getRole(),auth.getStatus());
        if (token.isEmpty())
            throw new AuthServiceException(EErrorType.TOKEN_NOT_CREATED);
        return LoginResponseDto.builder().id(auth.getId()).token(token.get()).role(auth.getRole().name()).build();
    }
}
