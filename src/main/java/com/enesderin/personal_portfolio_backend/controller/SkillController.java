package com.enesderin.personal_portfolio_backend.controller;

import com.enesderin.personal_portfolio_backend.dto.request.SkillRequest;
import com.enesderin.personal_portfolio_backend.dto.response.SkillResponse;

import java.util.List;

public interface SkillController {
    RootEntity<List<SkillResponse>> getAllSkills();
    RootEntity<SkillResponse> createSkill(SkillRequest request);
    RootEntity<SkillResponse> updateSkill(Long id, SkillRequest request);
    RootEntity<String> deleteSkill(Long id);
}
