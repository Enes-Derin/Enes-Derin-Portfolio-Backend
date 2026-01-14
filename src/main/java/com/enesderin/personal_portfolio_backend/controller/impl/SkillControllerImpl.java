package com.enesderin.personal_portfolio_backend.controller.impl;

import com.enesderin.personal_portfolio_backend.controller.RestBaseController;
import com.enesderin.personal_portfolio_backend.controller.RootEntity;
import com.enesderin.personal_portfolio_backend.controller.SkillController;
import com.enesderin.personal_portfolio_backend.dto.request.SkillRequest;
import com.enesderin.personal_portfolio_backend.dto.response.SkillResponse;
import com.enesderin.personal_portfolio_backend.repository.SkillRepository;
import com.enesderin.personal_portfolio_backend.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillControllerImpl extends RestBaseController implements SkillController {

    private SkillService skillService;

    @GetMapping
    @Override
    public RootEntity<List<SkillResponse>> getAllSkills() {
        return ok(skillService.getSkills());
    }

    @PostMapping(value = "/admin", consumes = "multipart/form-data")
    @Override
    public RootEntity<SkillResponse> createSkill(
            @ModelAttribute SkillRequest request) {
        return ok(skillService.createSkill(request));
    }

    @PutMapping(value = "/admin/{id}", consumes = "multipart/form-data")
    public RootEntity<SkillResponse> updateSkill(
            @PathVariable Long id,
            @ModelAttribute SkillRequest request
    ) {
        return ok(skillService.updateSkill(id, request));
    }

    @DeleteMapping("/admin/{id}")
    @Override
    public RootEntity<String> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ok("Deleted skill with id " + id);
    }
}