package com.enesderin.personal_portfolio_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutResponse {

    private Long id;

    private String aboutText;
    private String profileImage;
}
