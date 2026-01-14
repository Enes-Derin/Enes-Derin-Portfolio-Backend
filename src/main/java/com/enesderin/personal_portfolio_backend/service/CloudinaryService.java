package com.enesderin.personal_portfolio_backend.service;

public interface CloudinaryService {

    String uploadSignature(String base64Signature, String publicIdPrefix);

    void deleteByUrl(String imageUrl);
}

