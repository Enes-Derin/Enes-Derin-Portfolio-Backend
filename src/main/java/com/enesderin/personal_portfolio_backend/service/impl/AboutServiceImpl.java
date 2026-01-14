package com.enesderin.personal_portfolio_backend.service.impl;

import com.enesderin.personal_portfolio_backend.dto.request.AboutRequest;
import com.enesderin.personal_portfolio_backend.dto.response.AboutResponse;
import com.enesderin.personal_portfolio_backend.model.About;
import com.enesderin.personal_portfolio_backend.repository.AboutRepository;
import com.enesderin.personal_portfolio_backend.service.AboutService;
import com.enesderin.personal_portfolio_backend.service.CloudinaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@AllArgsConstructor
public class AboutServiceImpl implements AboutService {

    private AboutRepository aboutRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public AboutResponse getAboutById(Long id) {
        Optional<About> optionalAbout = this.aboutRepository.findById(id);
        if (optionalAbout.isPresent()) {
            AboutResponse aboutResponse = new AboutResponse();
            aboutResponse.setId(id);
            aboutResponse.setAboutText(optionalAbout.get().getAboutText());
            aboutResponse.setProfileImage(optionalAbout.get().getProfileImage());
            return aboutResponse;
        }
        return null;
    }

    @Override
    public AboutResponse createAbout(AboutRequest aboutRequest) {

        // 🔥 HER ZAMAN ID = 1
        About about = aboutRepository.findById(1L)
                .orElse(new About(1L, null, null));

        about.setAboutText(aboutRequest.getAboutText());

        if (aboutRequest.getProfileImage() != null && !aboutRequest.getProfileImage().isEmpty()) {

            if (about.getProfileImage() != null) {
                cloudinaryService.deleteByUrl(about.getProfileImage());
            }

            try {
                String base64Image = Base64.getEncoder()
                        .encodeToString(aboutRequest.getProfileImage().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "about-profile"
                );

                about.setProfileImage(imageUrl);

            } catch (Exception e) {
                throw new RuntimeException("Image upload failed", e);
            }
        }

        // 🔥 save() artık MERGE çalıştırır → HATA YOK
        About saved = aboutRepository.save(about);

        return new AboutResponse(
                saved.getId(),
                saved.getAboutText(),
                saved.getProfileImage()
        );
    }

    @Override
    public AboutResponse updateAbout(Long id, AboutRequest aboutRequest) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("About not found"));

        about.setAboutText(aboutRequest.getAboutText());

        if (aboutRequest.getProfileImage() != null && !aboutRequest.getProfileImage().isEmpty()) {
            // Eski resmi sil
            cloudinaryService.deleteByUrl(about.getProfileImage());

            try {
                String base64Image = Base64.getEncoder()
                        .encodeToString(aboutRequest.getProfileImage().getBytes());

                String imageUrl = cloudinaryService.uploadSignature(
                        "data:image/png;base64," + base64Image,
                        "about-profile"
                );

                about.setProfileImage(imageUrl);
            } catch (Exception e) {
                throw new RuntimeException("Image update failed");
            }
        }

        About saved = aboutRepository.save(about);

        return new AboutResponse(
                saved.getId(),
                saved.getAboutText(),
                saved.getProfileImage()
        );
    }

    @Override
    public void deleteAbout(Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("About not found"));

        cloudinaryService.deleteByUrl(about.getProfileImage());
        aboutRepository.deleteById(id);
    }
}
