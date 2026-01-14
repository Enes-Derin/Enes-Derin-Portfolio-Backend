package com.enesderin.personal_portfolio_backend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutRequest {

    @NotNull
    private String aboutText;
    @NotNull
    private MultipartFile profileImage;
}
