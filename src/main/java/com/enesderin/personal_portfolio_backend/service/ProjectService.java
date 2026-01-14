package com.enesderin.personal_portfolio_backend.service;

import com.enesderin.personal_portfolio_backend.dto.request.ProjectRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    ProjectResponse getProjectById(Long id);
    List<ProjectResponse> getAllProject();
    ProjectResponse createProject(ProjectRequest projectRequest);
    ProjectResponse updateProject(Long id, ProjectRequest projectRequest);
    void deleteProject(Long id);
}
