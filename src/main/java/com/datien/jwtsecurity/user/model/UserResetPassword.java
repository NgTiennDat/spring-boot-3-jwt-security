package com.datien.jwtsecurity.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserResetPassword {

    @NotBlank(message = "email is mandatory")
    @Email(message = "email needs to be true")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String newPassword;
    @NotBlank(message = "password is mandatory")
    private String confirmPassword;
}
