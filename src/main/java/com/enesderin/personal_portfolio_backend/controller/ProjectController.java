package com.enesderin.personal_portfolio_backend.controller;

import com.enesderin.personal_portfolio_backend.dto.request.ProjectRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectController {

    RootEntity<List<ProjectResponse>> getAllProject();
    RootEntity<ProjectResponse> getProjectById(Long id);
    RootEntity<ProjectResponse> createProject(ProjectRequest projectRequest);
    RootEntity<ProjectResponse> updateProject(Long id, ProjectRequest projectRequest);
    RootEntity<String> deleteProject(Long id);
}
