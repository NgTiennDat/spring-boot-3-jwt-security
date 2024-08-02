package com.datien.jwtsecurity.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserResetPassword {
    private String email;
    private String newPassword;
    private String confirmPassword;
}
