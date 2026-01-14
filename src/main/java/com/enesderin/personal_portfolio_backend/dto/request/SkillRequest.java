package com.enesderin.personal_portfolio_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillRequest {
    private String name;
    private String percentage;
    private MultipartFile iconUrl;
}
