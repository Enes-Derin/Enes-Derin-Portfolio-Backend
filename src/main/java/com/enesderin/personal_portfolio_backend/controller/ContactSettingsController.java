package com.enesderin.personal_portfolio_backend.controller;

import com.enesderin.personal_portfolio_backend.dto.request.ContactSettingsRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ContactSettingsResponse;
import com.enesderin.personal_portfolio_backend.model.ContactSettings;

public interface ContactSettingsController {
    RootEntity<ContactSettingsResponse> getContactSettingsById(Long id);
    RootEntity<ContactSettingsResponse> saveContactSettings(ContactSettingsRequest contactSettingsRequest);
    RootEntity<ContactSettingsResponse> updateContactSettings(Long id,ContactSettingsRequest contactSettingsRequest);
    RootEntity<String> deleteContactSettingsById(Long id);
}
