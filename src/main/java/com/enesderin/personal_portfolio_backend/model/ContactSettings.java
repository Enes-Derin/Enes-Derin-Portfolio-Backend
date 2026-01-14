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
public class ContactSettings {

    @Id
    private Long id;

    private String email;
    private String phone;
    private String location;
    private String linkedinLink;
    private String githubLink;
}
