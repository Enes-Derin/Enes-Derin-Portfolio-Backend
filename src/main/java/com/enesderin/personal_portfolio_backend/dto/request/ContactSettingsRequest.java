package com.enesderin.personal_portfolio_backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactSettingsRequest {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String phone;
    @NotNull
    private String location;
    @NotNull
    private String linkedinLink;
    @NotNull
    private String githubLink;
}
