package com.enesderin.personal_portfolio_backend.service.impl;

import com.enesderin.personal_portfolio_backend.dto.request.ContactSettingsRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ContactSettingsResponse;
import com.enesderin.personal_portfolio_backend.model.ContactSettings;
import com.enesderin.personal_portfolio_backend.repository.ContactSettingsRepository;
import com.enesderin.personal_portfolio_backend.service.ContactSettingsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactSettingsServiceImpl implements ContactSettingsService {

    private ContactSettingsRepository contactSettingsRepository;



    @Override
    public ContactSettingsResponse getContactSettings(Long id) {
        Optional<ContactSettings> contactSettings = this.contactSettingsRepository.findById(id);
        if (contactSettings.isPresent()) {
            ContactSettingsResponse contactSettingsResponse = new ContactSettingsResponse();
            contactSettingsResponse.setId(contactSettings.get().getId());
            contactSettingsResponse.setEmail(contactSettings.get().getEmail());
            contactSettingsResponse.setPhone(contactSettings.get().getPhone());
            contactSettingsResponse.setLocation(contactSettings.get().getLocation());
            contactSettingsResponse.setGithubLink(contactSettings.get().getGithubLink());
            contactSettingsResponse.setLinkedinLink(contactSettings.get().getLinkedinLink());
            return contactSettingsResponse;
        }
        return null;
    }


    @Override
    public ContactSettingsResponse addContactSettings(ContactSettingsRequest request) {

        // 🔥 HER ZAMAN ID = 1
        ContactSettings contactSettings = contactSettingsRepository.findById(1L)
                .orElse(new ContactSettings(1L, null, null, null, null, null));

        contactSettings.setEmail(request.getEmail());
        contactSettings.setPhone(request.getPhone());
        contactSettings.setLocation(request.getLocation());
        contactSettings.setGithubLink(request.getGithubLink());
        contactSettings.setLinkedinLink(request.getLinkedinLink());

        ContactSettings saved = contactSettingsRepository.save(contactSettings);

        return new ContactSettingsResponse(
                saved.getId(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getLocation(),
                saved.getGithubLink(),
                saved.getLinkedinLink()
        );
    }

    @Override
    public ContactSettingsResponse updateContactSettings(Long ignoredId, ContactSettingsRequest request) {

        // 🔥 ID PARAMETRESİ YOK SAYILIR
        ContactSettings contactSettings = contactSettingsRepository.findById(1L)
                .orElse(new ContactSettings(1L, null, null, null, null, null));

        contactSettings.setEmail(request.getEmail());
        contactSettings.setPhone(request.getPhone());
        contactSettings.setLocation(request.getLocation());
        contactSettings.setGithubLink(request.getGithubLink());
        contactSettings.setLinkedinLink(request.getLinkedinLink());

        ContactSettings saved = contactSettingsRepository.save(contactSettings);

        return new ContactSettingsResponse(
                saved.getId(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getLocation(),
                saved.getGithubLink(),
                saved.getLinkedinLink()
        );
    }

    @Override
    public void deleteContactSettingsById(Long id) {
        this.contactSettingsRepository.deleteById(id);
    }

}
