package com.enesderin.personal_portfolio_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroSectionResponse {
    private Long id;
    private String title;
    private String subtitle;
    private String buttonText;
    private String buttonLink;
    private String backgroundImage;
}
