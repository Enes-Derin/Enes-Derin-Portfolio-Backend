package com.enesderin.personal_portfolio_backend.controller.impl;

import com.enesderin.personal_portfolio_backend.controller.ProjectController;
import com.enesderin.personal_portfolio_backend.controller.RestBaseController;
import com.enesderin.personal_portfolio_backend.controller.RootEntity;
import com.enesderin.personal_portfolio_backend.dto.request.ProjectRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ProjectResponse;
import com.enesderin.personal_portfolio_backend.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectControllerImpl extends RestBaseController implements ProjectController {

    private ProjectService projectService;

    @GetMapping("/all")
    @Override
    public RootEntity<List<ProjectResponse>> getAllProject() {
        return ok(projectService.getAllProject());
    }

    @GetMapping("/{id}")
    @Override
    public RootEntity<ProjectResponse> getProjectById(@PathVariable Long id) {
        return ok(projectService.getProjectById(id));
    }

    @PostMapping(value = "/admin", consumes = "multipart/form-data")
    @Override
    public RootEntity<ProjectResponse> createProject(
            @ModelAttribute ProjectRequest projectRequest) {
        return ok(projectService.createProject(projectRequest));
    }

    @PutMapping(value = "/admin/{id}", consumes = "multipart/form-data")
    @Override
    public RootEntity<ProjectResponse> updateProject(
            @PathVariable Long id,
            @ModelAttribute ProjectRequest projectRequest) {
        return ok(projectService.updateProject(id, projectRequest));
    }

    @DeleteMapping("/admin/{id}")
    @Override
    public RootEntity<String> deleteProject(@PathVariable Long id) {
        this.projectService.deleteProject(id);
        return ok("Project deleted successfully");
    }
}
