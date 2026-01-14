package com.enesderin.personal_portfolio_backend.controller;

import com.enesderin.personal_portfolio_backend.dto.request.HeroSectionRequest;
import com.enesderin.personal_portfolio_backend.dto.response.HeroSectionResponse;
import jakarta.persistence.criteria.Root;

public interface HeroSectionController {
    RootEntity<HeroSectionResponse> getHeroSection(Long id);
    RootEntity<HeroSectionResponse> createHeroSection(HeroSectionRequest heroSectionRequest);
    RootEntity<HeroSectionResponse> updateHeroSection(Long id, HeroSectionRequest heroSectionRequest);
    RootEntity<String> deleteHeroSection(Long id);
}
