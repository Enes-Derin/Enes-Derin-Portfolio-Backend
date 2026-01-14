package com.enesderin.personal_portfolio_backend.repository;

import com.enesderin.personal_portfolio_backend.model.HeroSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroSectionRepository extends JpaRepository<HeroSection, Long> {
}
