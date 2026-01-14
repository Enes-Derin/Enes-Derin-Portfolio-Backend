package com.enesderin.personal_portfolio_backend.dto.auth;

import com.enesderin.personal_portfolio_backend.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;


    @NotNull
    private Role role;
}
