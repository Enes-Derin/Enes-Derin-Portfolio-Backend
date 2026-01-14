package com.enesderin.personal_portfolio_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactSettingsResponse {
    private Long id;

    private String email;
    private String phone;
    private String location;
    private String linkedinLink;
    private String githubLink;
}
