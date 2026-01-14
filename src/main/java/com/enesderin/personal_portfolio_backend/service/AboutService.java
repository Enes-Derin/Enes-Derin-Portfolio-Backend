package com.enesderin.personal_portfolio_backend.service;

import com.enesderin.personal_portfolio_backend.dto.request.AboutRequest;
import com.enesderin.personal_portfolio_backend.dto.response.AboutResponse;

public interface AboutService {
    AboutResponse getAboutById(Long id);
    AboutResponse createAbout(AboutRequest aboutRequest);
    AboutResponse updateAbout(Long id, AboutRequest aboutRequest);
    void deleteAbout(Long id);
}
