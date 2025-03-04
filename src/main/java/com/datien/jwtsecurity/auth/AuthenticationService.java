package com.datien.jwtsecurity.auth;

import com.datien.jwtsecurity.auth.model.AuthenticationRequest;
import com.datien.jwtsecurity.auth.model.AuthenticationResponse;
import com.datien.jwtsecurity.auth.model.RegistrationRequest;
import com.datien.jwtsecurity.token.Token;
import com.datien.jwtsecurity.token.TokenRepository;
import com.datien.jwtsecurity.token.TokenType;
import com.datien.jwtsecurity.user.daos.UserRepository;
import com.datien.jwtsecurity.jwtUtils.JwtService;
import com.datien.jwtsecurity.user.model.Role;
import com.datien.jwtsecurity.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final TokenRepository tokenRepository;

    public AuthenticationResponse register(RegistrationRequest request) {

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        saveUserToken(savedUser, jwtToken);
        return buildAuthResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        var auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var claims = new HashMap<String, Object>();
        var user = ((User) auth.getPrincipal());
        claims.put("fullName", user.fullname());
        var jwtToken = jwtService.generateToken(claims, (User) auth.getPrincipal());
//        revokeAllUserTokens(user);
//        saveUserToken(user, jwtToken);

        return buildAuthResponse(jwtToken);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());

        if(validUserTokens.isEmpty()) {
            return;
        }
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        tokenRepository.saveAll(validUserTokens);

    }

    private void saveUserToken(User user, String jwtToken) {

        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private AuthenticationResponse buildAuthResponse(String jwtToken) {
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
