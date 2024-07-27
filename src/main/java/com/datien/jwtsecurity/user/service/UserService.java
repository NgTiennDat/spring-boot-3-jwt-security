package com.datien.jwtsecurity.user.service;

import com.datien.jwtsecurity.user.daos.UserRepository;
import com.datien.jwtsecurity.user.model.ChangePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public void changePassword(ChangePasswordRequest request, Authentication connectedUser) {
    }
}
