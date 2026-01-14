package com.enesderin.personal_portfolio_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroSectionRequest {
    private String title;
    private String subtitle;
    private String buttonText;
    private String buttonLink;
    private MultipartFile backgroundImage;
}
