package com.enesderin.personal_portfolio_backend.service.impl;

import com.enesderin.personal_portfolio_backend.dto.request.HeroSectionRequest;
import com.enesderin.personal_portfolio_backend.dto.response.HeroSectionResponse;
import com.enesderin.personal_portfolio_backend.model.HeroSection;
import com.enesderin.personal_portfolio_backend.repository.HeroSectionRepository;
import com.enesderin.personal_portfolio_backend.service.CloudinaryService;
import com.enesderin.personal_portfolio_backend.service.HeroSectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HeroSectionServiceImpl implements HeroSectionService {

    private HeroSectionRepository heroSectionRepository;
    private CloudinaryService cloudinaryService;

    @Override
    public HeroSectionResponse getHeroSection(Long id) {
        Optional<HeroSection> optionalHeroSection = this.heroSectionRepository.findById(id);
        if (optionalHeroSection.isPresent()) {
            HeroSectionResponse heroSectionResponse = new HeroSectionResponse();
            heroSectionResponse.setId(id);
            heroSectionResponse.setSubtitle(optionalHeroSection.get().getSubtitle());
            heroSectionResponse.setTitle(optionalHeroSection.get().getTitle());
            heroSectionResponse.setButtonLink(optionalHeroSection.get().getButtonLink());
            heroSectionResponse.setBackgroundImage(optionalHeroSection.get().getBackgroundImage());
            heroSectionResponse.setButtonText(optionalHeroSection.get().getButtonText());
            return heroSectionResponse;
        }
        return null;
    }

    @Override
    public HeroSectionResponse createHeroSection(HeroSectionRequest request) {

        // 🔥 HER ZAMAN ID = 1
        HeroSection heroSection = heroSectionRepository.findById(1L)
                .orElse(new HeroSection(1L, null, null, null, null, null));

        heroSection.setTitle(request.getTitle());
        heroSection.setSubtitle(request.getSubtitle());
        heroSection.setButtonText(request.getButtonText());
        heroSection.setButtonLink(request.getButtonLink());

        if (request.getBackgroundImage() != null && !request.getBackgroundImage().isEmpty()) {

            if (heroSection.getBackgroundImage() != null) {
                cloudinaryService.deleteByUrl(heroSection.getBackgroundImage());
            }

            try {
                String base64Image = Base64.getEncoder()
                        .encodeToString(request.getBackgroundImage().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "hero-section-bg"
                );

                heroSection.setBackgroundImage(imageUrl);
            } catch (Exception e) {
                throw new RuntimeException("Hero background image upload failed", e);
            }
        }


        HeroSection saved = heroSectionRepository.save(heroSection);

        return new HeroSectionResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getSubtitle(),
                saved.getButtonText(),
                saved.getButtonLink(),
                saved.getBackgroundImage()
        );
    }

    @Override
    public HeroSectionResponse updateHeroSection(Long ignoredId, HeroSectionRequest request) {

        // 🔥 HER ZAMAN ID = 1
        HeroSection heroSection = heroSectionRepository.findById(1L)
                .orElse(new HeroSection(1L, null, null, null, null, null));

        heroSection.setTitle(request.getTitle());
        heroSection.setSubtitle(request.getSubtitle());
        heroSection.setButtonText(request.getButtonText());
        heroSection.setButtonLink(request.getButtonLink());

        if (request.getBackgroundImage() != null && !request.getBackgroundImage().isEmpty()) {

            if (heroSection.getBackgroundImage() != null) {
                cloudinaryService.deleteByUrl(heroSection.getBackgroundImage());
            }

            try {
                String base64Image = Base64.getEncoder()
                        .encodeToString(request.getBackgroundImage().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "hero-section-bg"
                );

                heroSection.setBackgroundImage(imageUrl);
            } catch (Exception e) {
                throw new RuntimeException("Hero background image update failed", e);
            }
        }

        HeroSection saved = heroSectionRepository.save(heroSection);

        return new HeroSectionResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getSubtitle(),
                saved.getButtonText(),
                saved.getButtonLink(),
                saved.getBackgroundImage()
        );
    }


    @Override
    public void deleteHeroSection(Long id) {
        HeroSection heroSection = heroSectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hero section not found"));

        cloudinaryService.deleteByUrl(heroSection.getBackgroundImage());
        heroSectionRepository.deleteById(id);
    }

}
