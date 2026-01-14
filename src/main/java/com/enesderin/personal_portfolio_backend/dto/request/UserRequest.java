package com.enesderin.personal_portfolio_backend.dto.request;

import com.enesderin.personal_portfolio_backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private Role role;
}
