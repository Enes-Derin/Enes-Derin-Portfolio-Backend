package com.enesderin.personal_portfolio_backend.repository;

import com.enesderin.personal_portfolio_backend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
