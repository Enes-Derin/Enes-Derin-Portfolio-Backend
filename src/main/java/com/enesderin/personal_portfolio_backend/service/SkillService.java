package com.enesderin.personal_portfolio_backend.service;

import com.enesderin.personal_portfolio_backend.dto.request.SkillRequest;
import com.enesderin.personal_portfolio_backend.dto.response.SkillResponse;

import java.util.List;

public interface SkillService {
    List<SkillResponse> getSkills();
    SkillResponse createSkill(SkillRequest request);
    SkillResponse updateSkill(Long id, SkillRequest request);
    void deleteSkill(Long id);
}
