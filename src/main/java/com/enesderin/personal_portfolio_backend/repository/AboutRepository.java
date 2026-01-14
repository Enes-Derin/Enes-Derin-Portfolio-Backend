package com.enesderin.personal_portfolio_backend.repository;

import com.enesderin.personal_portfolio_backend.model.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
}
