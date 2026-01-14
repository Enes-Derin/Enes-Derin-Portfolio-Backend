package com.enesderin.personal_portfolio_backend.controller.impl;

import com.enesderin.personal_portfolio_backend.controller.HeroSectionController;
import com.enesderin.personal_portfolio_backend.controller.RestBaseController;
import com.enesderin.personal_portfolio_backend.controller.RootEntity;
import com.enesderin.personal_portfolio_backend.dto.request.HeroSectionRequest;
import com.enesderin.personal_portfolio_backend.dto.response.HeroSectionResponse;
import com.enesderin.personal_portfolio_backend.service.HeroSectionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hero-section")
@AllArgsConstructor
public class HeroSectionControllerImpl extends RestBaseController implements HeroSectionController {

    private HeroSectionService heroSectionService;

    @GetMapping("/{id}")
    @Override
    public RootEntity<HeroSectionResponse> getHeroSection(@PathVariable Long id) {
        return ok(heroSectionService.getHeroSection(id));
    }

    @PostMapping(value = "/admin", consumes = "multipart/form-data")
    @Override
    public RootEntity<HeroSectionResponse> createHeroSection(
            @ModelAttribute HeroSectionRequest heroSectionRequest) {
        return ok(heroSectionService.createHeroSection(heroSectionRequest));
    }

    @PutMapping(value = "/admin/{id}", consumes = "multipart/form-data")
    @Override
    public RootEntity<HeroSectionResponse> updateHeroSection(
            @PathVariable Long id,
            @ModelAttribute HeroSectionRequest heroSectionRequest) {
        return ok(heroSectionService.updateHeroSection(id, heroSectionRequest));
    }

    @DeleteMapping("admin/{id}")
    @Override
    public RootEntity<String> deleteHeroSection(@PathVariable Long id) {
        this.heroSectionService.deleteHeroSection(id);
        return ok("Deleted hero section");
    }
}
