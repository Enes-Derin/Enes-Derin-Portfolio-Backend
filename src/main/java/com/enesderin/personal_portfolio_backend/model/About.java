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
public class About {

    @Id
    private Long id;

    @Lob
    private String aboutText;
    private String profileImage;
}
