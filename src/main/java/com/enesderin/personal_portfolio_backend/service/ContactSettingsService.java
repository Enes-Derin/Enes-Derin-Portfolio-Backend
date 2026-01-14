package com.enesderin.personal_portfolio_backend.service;

import com.enesderin.personal_portfolio_backend.dto.request.ContactSettingsRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ContactSettingsResponse;

public interface ContactSettingsService {
    ContactSettingsResponse getContactSettings(Long id);
    ContactSettingsResponse addContactSettings(ContactSettingsRequest contactSettingsRequest);
    ContactSettingsResponse updateContactSettings(Long id, ContactSettingsRequest contactSettingsRequest);
    void deleteContactSettingsById(Long id);
}
