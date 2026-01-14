package com.enesderin.personal_portfolio_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
    private String title;
    private String description;
    private String githubLink;
    private String demoLink;
    private String techStack;

    private MultipartFile image;
}
