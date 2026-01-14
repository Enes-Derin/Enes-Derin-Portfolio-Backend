package com.enesderin.personal_portfolio_backend.controller;

import com.enesderin.personal_portfolio_backend.dto.request.AboutRequest;
import com.enesderin.personal_portfolio_backend.dto.response.AboutResponse;

public interface AboutController {

    RootEntity<AboutResponse> getAboutById(Long id);
    RootEntity<AboutResponse> createAbout(AboutRequest aboutRequest);
    RootEntity<AboutResponse> updateAbout(Long id, AboutRequest aboutRequest);
    RootEntity<String> deleteAbout(Long id);
}
