package com.enesderin.personal_portfolio_backend.service.impl;

import com.enesderin.personal_portfolio_backend.dto.request.SkillRequest;
import com.enesderin.personal_portfolio_backend.dto.response.SkillResponse;
import com.enesderin.personal_portfolio_backend.model.Skill;
import com.enesderin.personal_portfolio_backend.repository.SkillRepository;
import com.enesderin.personal_portfolio_backend.service.CloudinaryService;
import com.enesderin.personal_portfolio_backend.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;
    private CloudinaryService cloudinaryService;

    @Override
    public List<SkillResponse> getSkills() {
        return skillRepository.findAll().stream().map(skill -> {
            SkillResponse response = new SkillResponse();
            response.setId(skill.getId());
            response.setName(skill.getName());
            response.setPercentage(skill.getPercentage());
            response.setIconUrl(skill.getIconUrl());
            return response;
        }).toList();
    }

    @Override
    public SkillResponse createSkill(SkillRequest request) {

        Skill skill = new Skill();
        skill.setName(request.getName());
        skill.setPercentage(request.getPercentage());

        if (request.getIconUrl() != null && !request.getIconUrl().isEmpty()) {
            try {
                String base64Image = Base64.getEncoder()
                        .encodeToString(request.getIconUrl().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "skills-icons"
                );

                skill.setIconUrl(imageUrl);

            } catch (Exception e) {
                throw new RuntimeException("Skill icon upload failed", e);
            }
        }

        Skill saved = skillRepository.save(skill);

        SkillResponse response = new SkillResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setPercentage(saved.getPercentage());
        response.setIconUrl(saved.getIconUrl());

        return response;
    }

    @Override
    public SkillResponse updateSkill(Long id, SkillRequest request) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        skill.setName(request.getName());
        skill.setPercentage(request.getPercentage());

        if (request.getIconUrl() != null && !request.getIconUrl().isEmpty()) {
            try {
                // Önce eski icon'u sil
                if (skill.getIconUrl() != null) {
                    cloudinaryService.deleteByUrl(skill.getIconUrl());
                }

                String base64Image = Base64.getEncoder()
                        .encodeToString(request.getIconUrl().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "skills-icons"
                );

                skill.setIconUrl(imageUrl);

            } catch (Exception e) {
                throw new RuntimeException("Skill icon upload failed", e);
            }
        }

        Skill saved = skillRepository.save(skill);

        SkillResponse response = new SkillResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setPercentage(saved.getPercentage());
        response.setIconUrl(saved.getIconUrl());

        return response;
    }


    @Override
    public void deleteSkill(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        if (skill.getIconUrl() != null) {
            cloudinaryService.deleteByUrl(skill.getIconUrl());
        }

        skillRepository.deleteById(id);
    }
}
