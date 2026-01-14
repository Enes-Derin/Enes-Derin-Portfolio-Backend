package com.enesderin.personal_portfolio_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {
    private Long id;
    private String title;
    private String description;
    private String githubLink;
    private String demoLink;

    private String techStack;
    private String imageUrl;
}
