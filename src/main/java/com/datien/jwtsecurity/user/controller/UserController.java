package com.datien.jwtsecurity.user.controller;

import com.datien.jwtsecurity.user.model.ChangePasswordRequest;
import com.datien.jwtsecurity.user.model.UserForgotPassword;
import com.datien.jwtsecurity.user.model.UserResetPassword;
import com.datien.jwtsecurity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/password/change")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Authentication connectedUser
    ) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/password/forgot")
    public ResponseEntity<?> forgotPassword(
            @RequestBody UserForgotPassword userForgotPassword
    ) {
        userService.forgotPassword(userForgotPassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/password/reset")
    public ResponseEntity<?> resetPassword(
            @RequestBody UserResetPassword userResetPassword
    ) {
        userService.resetPassword(userResetPassword);
        return ResponseEntity.ok().build();
    }
}
