package com.enesderin.personal_portfolio_backend.controller.impl;

import com.enesderin.personal_portfolio_backend.controller.ContactSettingsController;
import com.enesderin.personal_portfolio_backend.controller.RestBaseController;
import com.enesderin.personal_portfolio_backend.controller.RootEntity;
import com.enesderin.personal_portfolio_backend.dto.request.ContactSettingsRequest;
import com.enesderin.personal_portfolio_backend.dto.response.ContactSettingsResponse;
import com.enesderin.personal_portfolio_backend.model.Role;
import com.enesderin.personal_portfolio_backend.repository.ContactSettingsRepository;
import com.enesderin.personal_portfolio_backend.service.ContactSettingsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cantact-settings")
@AllArgsConstructor
public class ContactSettingsControllerImpl extends RestBaseController implements ContactSettingsController {

    private ContactSettingsService contactSettingsService;


    @GetMapping("/{id}")
    @Override
    public RootEntity<ContactSettingsResponse> getContactSettingsById(@PathVariable Long id) {
        return ok(this.contactSettingsService.getContactSettings(id));
    }

    @PostMapping("/admin")
    @Override
    public RootEntity<ContactSettingsResponse> saveContactSettings(@RequestBody ContactSettingsRequest contactSettingsRequest) {
        return ok(this.contactSettingsService.addContactSettings(contactSettingsRequest));
    }

    @PutMapping("/admin/{id}")
    @Override
    public RootEntity<ContactSettingsResponse> updateContactSettings(@PathVariable Long id,@RequestBody ContactSettingsRequest contactSettingsRequest) {
        return ok(this.contactSettingsService.updateContactSettings(id,contactSettingsRequest));
    }

    @DeleteMapping("/admin/{id}")
    @Override
    public RootEntity<String> deleteContactSettingsById(@PathVariable Long id) {
        this.contactSettingsService.deleteContactSettingsById(id);
        return ok("Deleted contactSettings with id " + id);
    }
}
