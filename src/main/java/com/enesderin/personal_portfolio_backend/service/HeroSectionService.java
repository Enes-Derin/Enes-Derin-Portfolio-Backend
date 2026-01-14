package com.enesderin.personal_portfolio_backend.service;

import com.enesderin.personal_portfolio_backend.dto.request.HeroSectionRequest;
import com.enesderin.personal_portfolio_backend.dto.response.HeroSectionResponse;

public interface HeroSectionService {
    HeroSectionResponse getHeroSection(Long id);
    HeroSectionResponse createHeroSection(HeroSectionRequest heroSectionRequest);
    HeroSectionResponse updateHeroSection(Long id,HeroSectionRequest heroSectionRequest);
    void deleteHeroSection(Long id);
}
