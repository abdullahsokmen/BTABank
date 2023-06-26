package com.project.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.project.exception.EErrorType;
import com.project.exception.AccountServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtTokenManager {

    @Value("${jwt.secretkey}")
    String secretKey;
    @Value("${jwt.issuer}")
    String issuer;
    @Value("${jwt.audience}")
    String audience;

    public Boolean validateToken(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC512(secretKey);
            JWTVerifier verifier=JWT.require(algorithm).withIssuer(issuer).withAudience(audience).build();
            DecodedJWT decodedJWT=verifier.verify(token);
            if (decodedJWT==null){
                return false;
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw new AccountServiceException(EErrorType.INVALID_TOKEN);
        }
        return true;
    }

    public Optional<String >getIdFromToken(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC512(secretKey);
            JWTVerifier verifier=JWT.require(algorithm).withIssuer(issuer).withAudience(audience).build();
            DecodedJWT decodedJWT=verifier.verify(token);
            if (decodedJWT==null){
                throw new AccountServiceException(EErrorType.INVALID_TOKEN);
            }
            String id=decodedJWT.getClaim("id").asString();
            return Optional.of(id);
        }catch (Exception exception){
            throw new AccountServiceException(EErrorType.INVALID_TOKEN);
        }

    }

    public Optional<String>getRoleFromToken(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC512(secretKey);
            JWTVerifier verifier=JWT.require(algorithm).withIssuer(issuer).withAudience(audience).build();
            DecodedJWT decodedJWT=verifier.verify(token);
            if (decodedJWT==null){
                throw new AccountServiceException(EErrorType.INVALID_TOKEN);
            }
            String role=decodedJWT.getClaim("role").asString();
            return Optional.of(role);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            throw new AccountServiceException(EErrorType.INVALID_TOKEN);
        }
    }

    public Optional<String> getStatusFromToken(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC512(secretKey);
            JWTVerifier verifier=JWT.require(algorithm).withIssuer(issuer).withAudience(audience).build();
            DecodedJWT decodedJWT=verifier.verify(token);
            if (decodedJWT==null){
                throw new AccountServiceException(EErrorType.INVALID_TOKEN);
            }
            String status = decodedJWT.getClaim("status").asString();
            return Optional.of(status);
        }catch (Exception exception){
            throw new AccountServiceException(EErrorType.INVALID_TOKEN);
        }
    }

}
