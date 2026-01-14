package com.enesderin.personal_portfolio_backend.controller.impl;

import com.enesderin.personal_portfolio_backend.controller.AboutController;
import com.enesderin.personal_portfolio_backend.controller.RestBaseController;
import com.enesderin.personal_portfolio_backend.controller.RootEntity;
import com.enesderin.personal_portfolio_backend.dto.request.AboutRequest;
import com.enesderin.personal_portfolio_backend.dto.response.AboutResponse;
import com.enesderin.personal_portfolio_backend.service.AboutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/about")
@AllArgsConstructor
public class AboutControllerImpl extends RestBaseController implements AboutController {

    private AboutService aboutService;

    @GetMapping("/{id}")
    @Override
    public RootEntity<AboutResponse> getAboutById(@PathVariable Long id) {
        return ok(aboutService.getAboutById(id));
    }

    @PostMapping(value = "/admin",consumes = "multipart/form-data")
    public RootEntity<AboutResponse> createAbout(@ModelAttribute AboutRequest aboutRequest) {
        return ok(aboutService.createAbout(aboutRequest));
    }

    @PutMapping(value = "/admin/{id}", consumes = "multipart/form-data")
    public RootEntity<AboutResponse> updateAbout(
            @PathVariable Long id,
            @ModelAttribute AboutRequest aboutRequest) {
        return ok(aboutService.updateAbout(id, aboutRequest));
    }

    @DeleteMapping("/admin/{id}")
    @Override
    public RootEntity<String> deleteAbout(@PathVariable Long id) {
        aboutService.deleteAbout(id);
        return ok("Deleted about successfully");
    }
}
