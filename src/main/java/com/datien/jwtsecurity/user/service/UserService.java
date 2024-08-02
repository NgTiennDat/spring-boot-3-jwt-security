package com.datien.jwtsecurity.user.service;

import com.datien.jwtsecurity.user.daos.UserRepository;
import com.datien.jwtsecurity.user.model.ChangePasswordRequest;
import com.datien.jwtsecurity.user.model.UserForgotPassword;
import com.datien.jwtsecurity.user.model.UserResetPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public void changePassword(ChangePasswordRequest request, Authentication connectedUser) {
    }

    public void forgotPassword(UserForgotPassword userForgotPassword) {
    }

    public void resetPassword(UserResetPassword userResetPassword) {

    }
}
