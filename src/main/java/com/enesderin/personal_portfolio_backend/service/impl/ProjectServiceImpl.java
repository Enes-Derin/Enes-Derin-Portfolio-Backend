package com.enesderin.personal_portfolio_backend.service.impl;

import com.enesderin.personal_portfolio_backend.dto.request.ProjectRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ProjectResponse;
import com.enesderin.personal_portfolio_backend.model.Project;
import com.enesderin.personal_portfolio_backend.repository.ProjectRepository;
import com.enesderin.personal_portfolio_backend.service.CloudinaryService;
import com.enesderin.personal_portfolio_backend.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private CloudinaryService cloudinaryService;

    @Override
    public ProjectResponse getProjectById(Long id) {
        Optional<Project> optionalProject = this.projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            ProjectResponse projectResponse = new ProjectResponse();
            projectResponse.setId(id);
            projectResponse.setDemoLink(optionalProject.get().getDemoLink());
            projectResponse.setDescription(optionalProject.get().getDescription());
            projectResponse.setGithubLink(optionalProject.get().getGithubLink());
            projectResponse.setTitle(optionalProject.get().getTitle());
            projectResponse.setImageUrl(optionalProject.get().getImageUrl());
            projectResponse.setTechStack(optionalProject.get().getTechStack());
            return projectResponse;
        }
        return null;
    }

    @Override
    public List<ProjectResponse> getAllProject() {
        List<Project> projectRepositoryAll = this.projectRepository.findAll();
        List<ProjectResponse> projectResponseList = new ArrayList<>();
        for (Project project : projectRepositoryAll) {
            ProjectResponse projectResponse = new ProjectResponse();
            projectResponse.setId(project.getId());
            projectResponse.setDemoLink(project.getDemoLink());
            projectResponse.setDescription(project.getDescription());
            projectResponse.setGithubLink(project.getGithubLink());
            projectResponse.setTitle(project.getTitle());
            projectResponse.setImageUrl(project.getImageUrl());
            projectResponse.setTechStack(project.getTechStack());
            projectResponseList.add(projectResponse);
        }
        return projectResponseList;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        Project project = new Project();
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setGithubLink(request.getGithubLink());
        project.setDemoLink(request.getDemoLink());
        project.setTechStack(request.getTechStack());

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            try {
                String base64Image = Base64.getEncoder()
                        .encodeToString(request.getImage().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "projects"
                );

                project.setImageUrl(imageUrl);
            } catch (Exception e) {
                throw new RuntimeException("Project image upload failed");
            }
        }

        Project saved = projectRepository.save(project);

        return new ProjectResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getGithubLink(),
                saved.getDemoLink(),
                saved.getTechStack(),
                saved.getImageUrl()
        );
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setGithubLink(request.getGithubLink());
        project.setDemoLink(request.getDemoLink());
        project.setTechStack(request.getTechStack());

        if (request.getImage() != null && !request.getImage().isEmpty()) {

            // eski görseli sil
            cloudinaryService.deleteByUrl(project.getImageUrl());

            try {
                String base64Image = Base64.getEncoder()
                        .encodeToString(request.getImage().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "projects"
                );

                project.setImageUrl(imageUrl);
            } catch (Exception e) {
                throw new RuntimeException("Project image update failed");
            }
        }

        Project saved = projectRepository.save(project);

        return new ProjectResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getGithubLink(),
                saved.getDemoLink(),
                saved.getTechStack(),
                saved.getImageUrl()
        );
    }
    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        cloudinaryService.deleteByUrl(project.getImageUrl());
        projectRepository.deleteById(id);
    }

}
