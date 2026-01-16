package com.enesderin.personal_portfolio_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class HeroSection {

    @Id
    private Long id;

    private String title;
    private String subtitle;
    private String buttonText;
    private String buttonLink;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String backgroundImage;
}
